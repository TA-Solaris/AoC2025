package d3;

import utils.Runner;
import d3.parser.*;

import java.util.Collections;
import java.util.List;

public class D3P2 implements Runner {

  @Override
  public String run(String input) {
    var banks = Parser.parse(input);
    long sum = 0;

    for (Bank bank : banks) {
      sum += Long.parseLong(GetJoltage(bank.batteries, 12));
    }

    return "Sum: " + sum;
  }

  public String GetJoltage(List<Integer> batteries, int digits) {
    if (digits == 0) {
      return "";
    }
    int n = batteries.size();
    int digit = Collections.max(batteries.subList(0, n - digits + 1));
    int firstIndex = batteries.indexOf(digit);
    List<Integer> newBatteries = batteries.subList(firstIndex + 1, n);
    return digit + GetJoltage(newBatteries, digits - 1);
  }
}
