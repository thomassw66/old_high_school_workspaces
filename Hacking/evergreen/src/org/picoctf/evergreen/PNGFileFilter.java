package org.picoctf.evergreen;

import java.io.File;
import javax.swing.filechooser.FileFilter;

public class PNGFileFilter extends FileFilter
{
  private static final String EXTENSION = "png";

  public boolean accept(File file)
  {
    if (file.isDirectory()) {
      return true;
    }
    String path = file.getAbsolutePath().toLowerCase();
    if ((path.endsWith("png")) && 
      (path.charAt(path.length() - 
      "png".length() - 1) == '.')) {
      return true;
    }
    return false;
  }

  public String getDescription()
  {
    return "PNG";
  }
}