package d4.parser;

import java.util.List;

public class Grid {
  public final List<List<Item>> grid;

  public Grid(List<List<Item>> grid) {
    this.grid = grid;
  }

  public Item getItem(int x, int y) {
    if (y >= getHeight()
        || x >= getWidth()
        || x < 0
        || y < 0) {
      return Item.Empty;
    }
    return grid.get(y).get(x);
  }

  public int getItemAroundCount(int x, int y) {
    int count = 0;

    int[] dx = { -1, 0, 1, -1, 1, -1, 0, 1 };
    int[] dy = { -1, -1, -1, 0, 0, 1, 1, 1 };

    for (int i = 0; i < dx.length; i++) {
      Item item = getItem(x + dx[i], y + dy[i]);
      if (item != Item.Empty) {
        count++;
      }
    }

    return count;
  }

  public int getHeight() {
    return grid.size();
  }

  public int getWidth() {
    return grid.isEmpty() ? 0 : grid.get(0).size();
  }
}
