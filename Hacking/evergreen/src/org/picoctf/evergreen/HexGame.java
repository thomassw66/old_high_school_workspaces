package org.picoctf.evergreen;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Random;
import java.util.Stack;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

public class HexGame extends JFrame
  implements MouseListener, KeyListener
{
  private static final long serialVersionUID = 4204616734239575363L;
  private static final int SIZE = 13;
  public static final int NEUTRAL = -1;
  public static final int X_OFF = 10;
  public static final int Y_OFF = 10;
  public static final int NUM_TEAMS = 2;
  public static final int NUM_HEXES = 127;
  private static final Random rand = new Random();
  private final Draft draft;
  private int currTeam = 0;
  private Hexagon[][] board = new Hexagon[13][13];
  private int numPlaces = 1;
  private boolean justCaptured = false;
  private Hexagon movingHex = null;
  private int movesRemaining = 1;
  private boolean canPlay = true;
  private boolean eitherOr = false;
  private int placeableType = 0;
  private boolean[] skippedLast = new boolean[2];
  private boolean justUndid = false;
  private int[] numPieces = new int[2];

  private final Stack<Hexagon[][]> boardStates = new Stack();
  private final Stack<GameState> turnStates = new Stack();
  private JFileChooser fc;

  public static void main(String[] arg)
  {
    new HexGame(Draft.AUBERGINE);
  }

  public HexGame(Draft d) {
    this.draft = d;
    setupFileChooser();
    initBoard();
    addMouseListener(this);
    addKeyListener(this);
    setPreferredSize(new Dimension(420, 500));
    setSize(getPreferredSize());
    setTitle("Evergreen");
    setResizable(false);
    setDefaultCloseOperation(3);
    setVisible(true);
  }

  private void initBoard() {
    if (this.draft.hasLimitedPieces())
      for (int i = 0; i < 2; i++)
        this.numPieces[i] = this.draft.numPieces;
    populateGrid();
    this.boardStates.push(getBoardCopy());
    this.turnStates.push(new GameState(this.currTeam, this.movesRemaining, this.numPlaces, 
      this.placeableType, this.eitherOr, false, Arrays.copyOf(this.numPieces, 
      2)));
  }

  private void populateGrid() {
    int h = 6; int N = this.draft.types;

    int count = 0;
    int[] numHexesOfType = new int[N];
    for (int row = 0; row < 13; row++) {
      int start = row <= 6 ? 0 : row - 6;
      int end = row <= 6 ? row + 6 : 12;
      for (int col = start; col <= end; col++) {
        this.board[row][col] = new Hexagon(row, col);
        count++;
        this.board[row][col].filled = false;
        if (this.draft.hasMultipleTypes())
          if ((row != 6) || (col != 6)) {
            int type;
            do
              type = rand.nextInt(N);
            while (numHexesOfType[type] == 127 / N);
            numHexesOfType[type] += 1;
            this.board[row][col].type = type;
          } else {
            this.board[row][col].type = 0;
          }
      }
    }
    System.out.println(count);

    if (this.draft.hasMultipleTypes())
      this.board[6][6].type = rand.nextInt(N);
  }

  public void paint(Graphics g) {
    g.setColor(Color.white);
    g.fillRect(0, 0, getWidth(), getHeight());

    for (Hexagon[] row : this.board) {
      for (Hexagon hex : row)
        if (hex != null)
          hex.draw(g, (this.numPlaces == 0) && (this.justCaptured) ? -1 : 
            this.placeableType);
    }
    drawGameInfo(g);
  }

  private void drawGameInfo(Graphics g) {
    g.setColor(Color.black);
    g.drawString("Currently player " + (this.currTeam + 1) + "'s (" + 
      Utilities.getColorNameForTeam(this.currTeam) + ") turn", 0, 490);
    g.drawString("either/or: " + this.eitherOr, 320, 435);
    g.drawString("places: " + this.numPlaces, 290, 450);
    g.drawString("just captured: " + this.justCaptured, 290, 465);
    g.drawString("moving hex: " + this.movingHex, 290, 480);
    g.drawString("moves: " + this.movesRemaining, 290, 495);
    g.drawString("Current draft: " + this.draft.toString(), 0, 40);
    if (this.draft.hasLimitedPieces())
      for (int i = 0; i < 2; i++)
        g.drawString("Team " + (i + 1) + ": " + this.numPieces[i], 340, 
          40 + 15 * i);
  }

  private long[] serializedState() {
    long[] s = new long[4];
    int bit = 0;
    for (Hexagon[] row : this.board) {
      for (Hexagon hex : row) {
        if (hex != null) {
          if (hex.team == 0) {
            s[((bit + 1) / 64)] |= 1 << (bit + 1) % 64;
          }
          else if (hex.team == 1) {
            s[(bit / 64)] |= 1 << bit % 64;
          }
          bit += 2;
        }
      }
    }
    return s;
  }

  private String stateString() {
    String s = "";
    for (Hexagon[] row : this.board) {
      for (Hexagon hex : row) {
        if (hex != null) {
          if (hex.team == 0) {
            s = s + "1";
          }
          else if (hex.team == 1)
            s = s + "2";
          else s = s + "0";
        }
      }
    }
    return s;
  }

  public void update() {
    for (Hexagon[] row : this.board) {
      for (Hexagon hex : row)
        if ((hex != null) && (wasCaptured(hex)) && (hex.team != -1))
          handleCaptured(hex);
    }
    if ((this.justCaptured) && (!this.draft.alwaysPlaceAfterCapture)) {
      this.justCaptured = rand.nextBoolean();
    }
    if ((this.draft.hasLimitedPieces()) && (this.numPieces[this.currTeam] <= 0))
      this.justCaptured = false;
    long[] s = serializedState();
    if ((s[0] == 1655855454L) && 
      (s[1] == -1843031447L) && 
      (s[2] == -937014477L) && 
      (s[3] == 374446087L)) {
      System.out.println("Success! Your key is on the next line.");
      System.out.println(stateString());
    }
  }

  private void handleCaptured(Hexagon hex) {
    hex.filled = false;
    hex.team = -1;
    this.justCaptured = true;
  }

  public void endTurn() {
    this.boardStates.push(getBoardCopy());
    this.currTeam = ((this.currTeam + 1) % 2);
    this.numPlaces = 1;
    this.justCaptured = false;
    this.movingHex = null;
    this.movesRemaining = 1;
    this.canPlay = true;
    this.eitherOr = false;

    handleDrafts();

    this.turnStates.push(new GameState(this.currTeam, this.movesRemaining, this.numPlaces, 
      this.placeableType, this.eitherOr, false, Arrays.copyOf(this.numPieces, 
      2)));

    repaint();

    if (!this.canPlay)
      endTurn();
  }

  private void handleDrafts() {
    boolean needToSkip = false;

    if (this.draft.specialState) {
      int option = rand.nextInt(6);
      if ((this.draft.skipOnlyOnce) && (this.skippedLast[this.currTeam] != false))
        while (option == 1)
          option = rand.nextInt(6);
      GameState s = this.draft.getStateForOption(option);
      needToSkip = s.skipTurn;
      this.canPlay = (!needToSkip);
      this.movesRemaining = s.movesRemaining;
      this.numPlaces = s.numPlaces;
      this.eitherOr = s.eitherOr;
    }

    if (this.draft.hasMultipleTypes()) {
      this.placeableType = rand.nextInt(this.draft.types);
    }
    this.skippedLast[this.currTeam] = needToSkip;

    if ((this.draft.hasLimitedPieces()) && (this.numPieces[this.currTeam] <= 0))
      this.numPlaces = 0;
  }

  public boolean wasCaptured(Hexagon h) {
    int row = h.row; int col = h.col;
    if ((row > 0) && (row < 12) && (col > 0) && (col < 12) && 
      (this.board[(row - 1)][(col - 1)] != null) && 
      (this.board[(row + 1)][(col + 1)] != null) && 
      (this.board[(row - 1)][(col - 1)].team == this.board[(row + 1)][(col + 1)].team) && 
      (this.board[(row - 1)][(col - 1)].team != h.team) && 
      (this.board[(row - 1)][(col - 1)].team != -1)) {
      return true;
    }
    if ((row > 0) && (row < 12) && 
      (this.board[(row - 1)][col] != null) && (this.board[(row + 1)][col] != null) && 
      (this.board[(row - 1)][col].team == this.board[(row + 1)][col].team) && 
      (this.board[(row - 1)][col].team != h.team) && 
      (this.board[(row - 1)][col].team != -1)) {
      return true;
    }
    if ((col > 0) && (col < 12) && 
      (this.board[row][(col - 1)] != null) && (this.board[row][(col + 1)] != null) && 
      (this.board[row][(col - 1)].team == this.board[row][(col + 1)].team) && 
      (this.board[row][(col - 1)].team != h.team) && 
      (this.board[row][(col - 1)].team != -1)) {
      return true;
    }
    return false;
  }

  public boolean wasCaptured(int row, int col) {
    return wasCaptured(this.board[row][col]);
  }

  public void mouseClicked(MouseEvent e) {
    if (!this.canPlay) {
      return;
    }
    Hexagon h = getClicked(e);
    if (h == null) {
      return;
    }
    this.justUndid = false;
    int r = h.row; int c = h.col;
    if ((r != -1) && (c != -1)) {
      if (this.board[r][c].filled) {
        if ((this.board[r][c].team == this.currTeam) && 
          (this.movesRemaining > 0))
          this.movingHex = this.board[r][c];
      } else if (this.movingHex != null) {
        if (canMove(r, c))
          handleMove(r, c);
        else if ((this.numPlaces > 0) && (h.type == this.placeableType))
          handlePlace(r, c);
      } else if ((this.numPlaces > 0) && (h.type == this.placeableType))
        handlePlace(r, c);
      else if ((this.justCaptured) && (!moveWouldCapture(r, c))) {
        handleReplace(r, c);
      }
    }
    update();

    if ((this.eitherOr) && ((this.movesRemaining == 0) || (this.numPlaces == 0))) {
      this.movesRemaining = (this.numPlaces = 0);
    }
    if (((this.numPlaces == 0) && (this.movesRemaining == 0) && (!this.justCaptured)) || (!this.canPlay))
      endTurn();
    repaint();
  }

  private boolean canMove(int r, int c) {
    int or = this.movingHex.row;
    int oc = this.movingHex.col;
    if (((or - 1 == r) || (or == r) || (or + 1 == r)) && 
      ((oc - 1 == c) || (oc == c) || (oc + 1 == c)) && 
      ((oc - 1 != c) || (or + 1 != r)) && 
      ((oc + 1 != c) || (or - 1 != r)) && (
      (oc != c) || (or != r)))
      return true;
    return false;
  }

  private void handleMove(int r, int c) {
    this.board[r][c].filled = true;
    this.board[r][c].team = this.currTeam;
    if (wasCaptured(r, c)) {
      this.board[r][c].filled = false;
      this.board[r][c].team = -1;
    } else {
      this.movingHex.filled = false;
      this.movingHex.team = -1;
      this.movingHex = null;
      this.movesRemaining -= 1;
    }
  }

  private Hexagon getClicked(MouseEvent e)
  {
    Hexagon h = null;
    int x = e.getX() - 10; int y = e.getY() - 10;
    for (Hexagon[] row : this.board) {
      for (Hexagon hex : row) {
        if (hex != null) {
          int distSq = (hex.x - x) * (hex.x - x) + (hex.y - y) * (
            hex.y - y);
          if (distSq < 300)
          {
            h = hex;
            break;
          }
        }
      }
      if (h != null)
        break;
    }
    return h;
  }

  private void handlePlace(int r, int c) {
    this.numPlaces -= 1;
    this.board[r][c].filled = true;
    this.board[r][c].team = this.currTeam;
    if (wasCaptured(r, c)) {
      this.board[r][c].filled = false;
      this.board[r][c].team = -1;
      this.numPlaces += 1;
    } else {
      this.numPieces[this.currTeam] -= 1;
    }
  }

  private void handleReplace(int r, int c) { this.justCaptured = false;
    this.board[r][c].filled = true;
    this.board[r][c].team = this.currTeam;
    if (wasCaptured(r, c)) {
      this.board[r][c].filled = false;
      this.board[r][c].team = -1;
      this.justCaptured = true;
    } else {
      this.canPlay = false;
      this.numPieces[this.currTeam] -= 1;
    } }

  private boolean moveWouldCapture(int r, int c)
  {
    boolean filled = this.board[r][c].filled;
    int team = this.board[r][c].team;
    this.board[r][c].filled = true;
    this.board[r][c].team = this.currTeam;

    boolean would = false;
    if (r > 0) {
      if ((c > 0) && (this.board[(r - 1)][(c - 1)] != null) && 
        (this.board[(r - 1)][(c - 1)].team != this.currTeam) && 
        (this.board[(r - 1)][(c - 1)].team != -1) && 
        (wasCaptured(r - 1, c - 1))) {
        would = true;
      }
      if ((this.board[(r - 1)][c] != null) && (this.board[(r - 1)][c].team != this.currTeam) && 
        (this.board[(r - 1)][c].team != -1) && 
        (wasCaptured(r - 1, c))) {
        would = true;
      }
    }
    if ((c > 0) && 
      (this.board[r][(c - 1)] != null) && (this.board[r][(c - 1)].team != this.currTeam) && 
      (this.board[r][(c - 1)].team != -1) && 
      (wasCaptured(r, c - 1))) {
      would = true;
    }
    if (r < 12) {
      if ((this.board[(r + 1)][c] != null) && (this.board[(r + 1)][c].team != this.currTeam) && 
        (this.board[(r + 1)][c].team != -1) && 
        (wasCaptured(r + 1, c))) {
        would = true;
      }
      if ((c < 12) && (this.board[(r + 1)][(c + 1)] != null) && 
        (this.board[(r + 1)][(c + 1)].team != this.currTeam) && 
        (this.board[(r + 1)][(c + 1)].team != -1) && 
        (wasCaptured(r + 1, c + 1))) {
        would = true;
      }
    }
    if ((c < 12) && 
      (this.board[r][(c + 1)] != null) && (this.board[r][(c + 1)].team != this.currTeam) && 
      (this.board[r][(c + 1)].team != -1) && 
      (wasCaptured(r, c + 1))) {
      would = true;
    }
    this.board[r][c].filled = filled;
    this.board[r][c].team = team;

    return would;
  }

  public void mousePressed(MouseEvent e) {
  }

  public void mouseReleased(MouseEvent e) {
  }

  public void mouseEntered(MouseEvent e) {
  }

  public void mouseExited(MouseEvent e) {
  }

  public void keyPressed(KeyEvent e) {
    switch (e.getKeyCode()) {
    case 32:
      endTurn();
      break;
    case 127:
      handleUndo();
      repaint();
      break;
    case 83:
      handleSaveFile();
    }
  }

  public void keyReleased(KeyEvent e)
  {
  }

  public void keyTyped(KeyEvent e) {
  }

  private Hexagon[][] getBoardCopy() {
    Hexagon[][] copy = new Hexagon[13][13];
    for (int i = 0; i < this.board.length; i++)
      for (int j = 0; j < this.board[i].length; j++)
        copy[i][j] = (this.board[i][j] == null ? null : this.board[i][j].copy());
    return copy;
  }

  private void handleUndo() {
    if (this.justUndid) {
      this.boardStates.pop();
      this.turnStates.pop();
      if (this.boardStates.size() == 0)
        return;
    }
    this.board = ((Hexagon[][])this.boardStates.pop());
    GameState lastTurnState = (GameState)this.turnStates.pop();
    this.currTeam = lastTurnState.currTeam;
    this.movesRemaining = lastTurnState.movesRemaining;
    this.numPlaces = lastTurnState.numPlaces;
    this.placeableType = lastTurnState.placeableType;
    this.eitherOr = lastTurnState.eitherOr;
    this.numPieces = Arrays.copyOf(lastTurnState.numPieces, 2);
    this.justCaptured = false;
    this.boardStates.push(getBoardCopy());
    this.turnStates.push(lastTurnState);
    this.justUndid = true;
  }

  private void setupFileChooser() {
    this.fc = new JFileChooser();
    this.fc.setDialogTitle("Export Game");
    this.fc.addChoosableFileFilter(new PNGFileFilter());
  }

  private void handleSaveFile() {
    int returnVal = this.fc.showSaveDialog(this);
    if (returnVal == 0) {
      File file = this.fc.getSelectedFile();
      exportGameToFile(file);
    }
  }

  private void exportGameToFile(File f) {
    BufferedImage b = new BufferedImage(getWidth(), getHeight(), 
      1);
    Graphics g = b.getGraphics();
    paint(g);
    b = b.getSubimage(0, 10, getWidth(), getHeight() - 10);
    try {
      ImageIO.write(b, "png", f);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}