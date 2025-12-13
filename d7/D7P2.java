package d7;

import utils.Runner;
import d7.parser.*;

import java.util.Collections;
import java.util.Map;
import java.util.HashMap;

public class D7P2 implements Runner {

  @Override
  public String run(String input) {
    Board board = Parser.parse(input);
    int start = getStart(board.lines[0]);
    Map<Integer, Map<Integer, Long>> computeCache = new HashMap<>();
    return "Sum: " + (getSum(board, start, 0, computeCache) + 1);
  }

  private long getSum(Board board, int x, int y, Map<Integer, Map<Integer, Long>> computeCache) {
    if (y >= board.lines.length
        || x < 0
        || x >= board.lines[0].length()) {
      return 0;
    }

    if (board.lines[y].charAt(x) == '^') {
      return 1 + getSum(board, x - 1, y, computeCache) + getSum(board, x + 1, y, computeCache);
    }

    if (board.lines[y].charAt(x) == '|') {
      return computeCache.getOrDefault(y, Map.of()).get(x);
    }

    long sum = getSum(board, x, y + 1, computeCache);
    computeCache.computeIfAbsent(y, k -> new HashMap<>()).put(x, sum);
    board.lines[y] = addBeam(board.lines[y], x);
    return sum;
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
