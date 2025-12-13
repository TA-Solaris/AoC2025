package d7.parser;

import java.util.ArrayList;
import java.util.List;
import utils.Pair;

public class Parser {

  public static Board parse(String input) {
    String[] lines = input.split("\\R");
    return new Board(lines);
  }
}
