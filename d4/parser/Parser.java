package d4.parser;

import java.util.ArrayList;
import java.util.List;

public class Parser {

  public static Grid parse(String input) {
    List<List<Item>> grid = new ArrayList<>();
    String[] rows = input.split("\\R");

    for (String row : rows) {
      if (row.isBlank())
        continue;

      List<Item> items = new ArrayList<>();

      for (char c : row.toCharArray()) {
        if (c == '@') {
          items.add(Item.Paper);
        } else {
          items.add(Item.Empty);
        }
      }

      grid.add(items);
    }

    return new Grid(grid);
  }
}
