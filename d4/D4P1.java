package d4;

import utils.Runner;
import d4.parser.*;

import java.util.Collections;

public class D4P1 implements Runner {

  @Override
  public String run(String input) {
    var grid = Parser.parse(input);
    int sum = 0;

    for (int y = 0; y < grid.getHeight(); y++) {
      for (int x = 0; x < grid.getWidth(); x++) {
        if (grid.getItem(x, y) == Item.Paper
            && grid.getItemAroundCount(x, y) < 4) {
          sum++;
        }
      }
    }

    return "Sum: " + sum;
  }
}
