package d1;

import utils.Runner;
import d1.parser.Parser;
import d1.parser.Instruction;

public class D1P1 implements Runner {

  @Override
  public String run(String input) {
    var instructions = Parser.parse(input);

    int dial = 50;
    int count = 0;
    for (Instruction instruction : instructions) {
      switch (instruction.direction) {
        case 'L':
          dial -= instruction.value;
          break;
        case 'R':
          dial += instruction.value;
          break;
        default:
      }
      if (dial % 100 == 0) {
        count++;
      }
    }

    return "Count: " + count;
  }
}
