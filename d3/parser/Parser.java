package d3.parser;

import java.util.ArrayList;
import java.util.List;

public class Parser {

  public static List<Bank> parse(String input) {
    List<Bank> list = new ArrayList<>();

    String[] banks = input.split("\\R");

    for (String bank : banks) {
      if (bank.isBlank())
        continue;

      List<Integer> batteries = new ArrayList<>();

      for (char c : bank.toCharArray()) {
        batteries.add(Character.getNumericValue(c));
      }

      list.add(new Bank(batteries));
    }

    return list;
  }
}
