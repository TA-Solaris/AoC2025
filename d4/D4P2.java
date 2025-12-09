package d4;

import utils.Runner;
import d4.parser.*;

import java.util.Collections;

public class D4P2 implements Runner {

  @Override
  public String run(String input) {
    var grid = Parser.parse(input);
    int sum = 0;

    for (int y = 0; y < grid.getHeight(); y++) {
      for (int x = 0; x < grid.getWidth(); x++) {
        if (canRemove(grid, x, y)) {
          remove(grid, x, y);
          sum++;
          sum += removeAdjacent(grid, x, y);
        }
      }
    }

    return "Sum: " + sum;
  }

  private boolean canRemove(Grid grid, int x, int y) {
    return grid.getItem(x, y) == Item.Paper
        && grid.getItemAroundCount(x, y) < 4;
  }

  private void remove(Grid grid, int x, int y) {
    grid.grid.get(y).set(x, Item.Empty);
  }

  private int removeAdjacent(Grid grid, int x, int y) {
    int sum = 0;

    int[] dx = { -1, 0, 1, -1, 1, -1, 0, 1 };
    int[] dy = { -1, -1, -1, 0, 0, 1, 1, 1 };

    for (int i = 0; i < dx.length; i++) {
      if (canRemove(grid, x + dx[i], y + dy[i])) {
        remove(grid, x + dx[i], y + dy[i]);
        sum++;
        sum += removeAdjacent(grid, x + dx[i], y + dy[i]);
      }
    }

    return sum;
  }
}
