package com.ancbro;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Util {
  public static int countCharsInFile(String path) throws IOException {
    return new String(Files.readAllBytes(Paths.get(path))).length();
  }
}
