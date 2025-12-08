package d3;

import utils.Runner;
import d3.parser.*;

import java.util.Collections;

public class D3P1 implements Runner {

  @Override
  public String run(String input) {
    var banks = Parser.parse(input);
    int sum = 0;

    for (Bank bank : banks) {
      int n = bank.batteries.size();
      int digit1 = Collections.max(bank.batteries.subList(0, n - 1));
      int firstIndex = bank.batteries.indexOf(digit1);
      int digit2 = Collections.max(bank.batteries.subList(firstIndex + 1, n));
      sum += Integer.parseInt("" + digit1 + digit2);
    }

    return "Sum: " + sum;
  }
}
