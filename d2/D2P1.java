package d2;

import utils.Runner;
import d2.parser.*;

public class D2P1 implements Runner {

  @Override
  public String run(String input) {
    var ranges = Parser.parse(input);
    long sum = 0;

    for (ProductRange range : ranges) {
      long current = range.start;
      while (true) {
        long test = Long.parseLong("" + current + current);
        if (test > range.upper) {
          break;
        }
        if (test >= range.lower) {
          sum += test;
        }
        current++;
      }
    }

    return "Sum: " + sum;
  }
}
