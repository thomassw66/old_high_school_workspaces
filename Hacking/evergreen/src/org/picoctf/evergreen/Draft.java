package org.picoctf.evergreen;

public enum Draft
{
  AUBERGINE(1), BURGUNDY(6), 
  CRIMSON(6), DANDELION(2), EVERGREEN(1, true, true), 

  FUCHSIA(1, true, true), 

  GOLDENROD(1, true, false), 

  HONEYDEW(1, false), IRIS(3), JASPER(2, true, false, false, 20);

  public final int types;
  public final boolean alwaysPlaceAfterCapture;
  public final boolean specialState;
  public final boolean skipOnlyOnce;
  public final int numPieces;

  private Draft(int numTypes, boolean alwaysPlaceAfterCapture, boolean specialState, boolean skipOnlyOnce, int numPieces) { this.types = numTypes;
    this.alwaysPlaceAfterCapture = alwaysPlaceAfterCapture;
    this.specialState = specialState;
    this.skipOnlyOnce = skipOnlyOnce;
    this.numPieces = numPieces; }

  private Draft(int numTypes)
  {
    this(numTypes, true, false, false, -1);
  }

  private Draft(int numTypes, boolean alwaysPlace) {
    this(numTypes, alwaysPlace, false, false, -1);
  }

  private Draft(int numTypes, boolean special, boolean skipOnce) {
    this(numTypes, true, special, skipOnce, -1);
  }

  public boolean hasMultipleTypes() {
    return this.types > 1;
  }

  public boolean hasLimitedPieces() {
    return this.numPieces > 0;
  }

  public GameState getStateForOption(int option) {
    return null;
  }
}