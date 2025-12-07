package d1.parser;

import java.util.ArrayList;
import java.util.List;

public class Parser {

  public static List<Instruction> parse(String input) {
    List<Instruction> list = new ArrayList<>();

    String[] lines = input.split("\\R");

    for (String line : lines) {
      if (line.isBlank())
        continue;

      char direction = line.charAt(0);
      int number = Integer.parseInt(line.substring(1));

      list.add(new Instruction(direction, number));
    }

    return list;
  }
}
