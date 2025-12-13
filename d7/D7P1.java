package d7;

import utils.Runner;
import d7.parser.*;

import java.util.Collections;

public class D7P1 implements Runner {

  @Override
  public String run(String input) {
    Board board = Parser.parse(input);
    int start = getStart(board.lines[0]);
    return "Sum: " + getSum(board, start, 0);
  }

  private int getSum(Board board, int x, int y) {
    if (y >= board.lines.length
        || x < 0
        || x >= board.lines[0].length()
        || board.lines[y].charAt(x) == '|') {
      return 0;
    }

    if (board.lines[y].charAt(x) == '^') {
      return 1 + getSum(board, x - 1, y) + getSum(board, x + 1, y);
    }

    board.lines[y] = addBeam(board.lines[y], x);
    return getSum(board, x, y + 1);
  }

  private int getStart(String line) {
    for (int i = 0; i < line.length(); i++) {
      if (line.charAt(i) == 'S') {
        return i;
      }
    }

    return -1;
  }

  public static String addBeam(String s, int index) {
    char[] chars = s.toCharArray();
    chars[index] = '|';
    return new String(chars);
  }

}
