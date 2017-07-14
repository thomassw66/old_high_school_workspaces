package org.picoctf.evergreen;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;

public class Hexagon
{
  public final int row;
  public final int col;
  public final int y;
  public final int x;
  public int team = -1;
  public boolean filled;
  public int type = 0;
  public static final int SIDE_LENGTH = 20;

  public Hexagon(int row, int col)
  {
    this.row = row;
    this.col = col;
    this.y = ((int)((row + 3.5D - 0.5D * col) * Math.sqrt(3.0D) * 20.0D) + 22);
    if ((col & 0x1) == 0)
      this.x = (60 * (col / 2) + 20);
    else
      this.x = ((int)(20.0D * (1.5D * (col + 1) - 0.5D)));
  }

  public void draw(Graphics g, int selType) {
    if ((this.team != -1) || (this.type == selType) || (selType < 0)) {
      g.setColor(Utilities.getColorForTeam(this.team));
    } else if (this.type != selType) {
      g.setColor(Color.gray);
      this.filled = true;
    }

    Polygon p = new Polygon();
    for (int i = 0; i < 6; i++) {
      p.addPoint(
        (int)(10 + this.x + 20.0D * 
        Math.cos(i * 3.141592653589793D / 3.0D)), 
        (int)(10 + this.y + 20.0D * 
        Math.sin(i * 3.141592653589793D / 3.0D)));
    }
    if (this.filled)
      g.fillPolygon(p);
    g.setColor(Color.black);
    g.drawPolygon(p);

    if ((this.team == -1) && (this.type != selType))
      this.filled = false;
  }

  public Hexagon copy() {
    Hexagon h = new Hexagon(this.row, this.col);
    h.team = this.team;
    h.filled = this.filled;
    h.type = this.type;
    return h;
  }

  public String toString() {
    return "(" + this.row + ", " + this.col + ")";
  }
}