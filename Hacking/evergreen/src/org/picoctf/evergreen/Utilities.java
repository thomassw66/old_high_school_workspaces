package org.picoctf.evergreen;

import java.awt.Color;

public class Utilities
{
  public static Color getColorForTeam(int team)
  {
    switch (team) {
    case 0:
      return Color.blue;
    case 1:
      return Color.red;
    case 2:
      return Color.green;
    case 3:
      return Color.orange;
    case 4:
      return Color.magenta;
    case 5:
      return Color.cyan;
    }
    return Color.black;
  }

  public static String getColorNameForTeam(int team)
  {
    switch (team) {
    case 0:
      return "blue";
    case 1:
      return "red";
    case 2:
      return "green";
    case 3:
      return "orange";
    case 4:
      return "magenta";
    case 5:
      return "cyan";
    }
    return "black";
  }
}