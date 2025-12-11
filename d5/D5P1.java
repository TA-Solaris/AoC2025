package d5;

import utils.Runner;
import utils.Pair;
import d5.parser.*;

import java.util.Collections;

public class D5P1 implements Runner {

  @Override
  public String run(String input) {
    var inventory = Parser.parse(input);
    int sum = 0;

    for (Long id : inventory.ids) {
      for (Pair<Long, Long> range : inventory.ranges) {
        if (id >= range.getFirst()
            && id <= range.getSecond()) {
          sum++;
          break;
        }
      }
    }

    return "Sum: " + sum;
  }
}
