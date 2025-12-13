package d6.parser;

import java.util.ArrayList;
import java.util.List;
import utils.Pair;

public class Parser {

  public static List<Equation> parse(String input) {
    List<Equation> equations = new ArrayList<>();
    String[] lines = input.split("\\R");
    List<Pair<String[], Character>> blocks = splitBlocks(lines);

    for (Pair<String[], Character> block : blocks) {
      List<Long> horizontal = parseHorizontal(block.getFirst());
      List<Long> vertical = parseVertical(block.getFirst());
      equations
          .add(new Equation(horizontal, vertical, block.getSecond()));
    }

    return equations;
  }

  private static List<Pair<String[], Character>> splitBlocks(String[] lines) {
    int rows = lines.length;
    int cols = lines[0].length();

    boolean[] separator = new boolean[cols];
    for (int c = 0; c < cols; c++) {
      final int col = c;
      separator[c] = java.util.stream.IntStream.range(0, rows)
          .allMatch(r -> lines[r].charAt(col) == ' ');
    }

    List<Pair<String[], Character>> result = new ArrayList<>();

    int start = 0;
    for (int c = 0; c <= cols; c++) {
      if (c == cols || separator[c]) {
        if (start < c) {
          String[] numbers = new String[rows - 1];
          for (int r = 0; r < rows - 1; r++) {
            numbers[r] = lines[r].substring(start, c);
          }

          char op = ' ';
          String opSlice = lines[rows - 1].substring(start, c);
          for (char ch : opSlice.toCharArray()) {
            if (ch != ' ') {
              op = ch;
              break;
            }
          }

          result.add(new Pair<>(numbers, op));
        }
        start = c + 1;
      }
    }

    return result;
  }

  private static List<Long> parseHorizontal(String[] lines) {
    List<Long> result = new ArrayList<>();

    for (String row : lines) {
      String digits = row.replace(" ", "");
      if (!digits.isEmpty()) {
        result.add(Long.parseLong(digits));
      }
    }

    return result;
  }

  private static List<Long> parseVertical(String[] block) {
    List<Long> result = new ArrayList<>();

    int rows = block.length;
    int cols = block[0].length();

    for (int c = 0; c < cols; c++) {
      StringBuilder sb = new StringBuilder();

      for (int r = 0; r < rows; r++) {
        char ch = block[r].charAt(c);
        if (ch != ' ') {
          sb.append(ch);
        }
      }

      if (sb.length() > 0) {
        result.add(Long.parseLong(sb.toString()));
      }
    }

    return result;
  }
}
