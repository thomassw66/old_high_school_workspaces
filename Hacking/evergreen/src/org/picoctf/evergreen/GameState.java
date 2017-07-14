package org.picoctf.evergreen;

public class GameState
{
  public final int currTeam;
  public final int movesRemaining;
  public final int numPlaces;
  public final int placeableType;
  public final boolean eitherOr;
  public final boolean skipTurn;
  public final int[] numPieces;

  public GameState(int team, int moves, int places, int type, boolean or, boolean skip, int[] pieces)
  {
    this.currTeam = team;
    this.movesRemaining = moves;
    this.numPlaces = places;
    this.placeableType = type;
    this.eitherOr = or;
    this.skipTurn = skip;
    this.numPieces = pieces;
  }

  public GameState(int team, int moves, int places, int type, boolean or) {
    this(team, moves, places, type, or, false, null);
  }

  public GameState(int moves, int places, boolean or, boolean skip) {
    this(-1, moves, places, 0, or, skip, null);
  }
}