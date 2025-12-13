package d6;

import utils.Runner;
import d6.parser.*;

import java.util.Collections;

public class D6P1 implements Runner {

  @Override
  public String run(String input) {
    var equations = Parser.parse(input);
    long sum = 0;

    for (Equation e : equations) {
      sum += calculate(e);
    }

    return "Sum: " + sum;
  }

  private Long calculate(Equation equation) {
    long sum = equation.symbol == '+' ? 0 : 1;

    for (Long num : equation.horizontal) {
      if (equation.symbol == '+') {
        sum = sum + num;
      } else {
        sum = sum * num;
      }
    }

    return sum;
  }
}
