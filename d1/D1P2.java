package d1;

import utils.Runner;
import d1.parser.Parser;
import d1.parser.Instruction;

public class D1P2 implements Runner {

  @Override
  public String run(String input) {
    var instructions = Parser.parse(input);

    int dial = 50;
    int count = 0;
    for (Instruction instruction : instructions) {
      count += instruction.value / 100;
      int spins = instruction.value % 100;
      while (spins > 0) {
        switch (instruction.direction) {
          case 'L':
            dial--;
            break;
          case 'R':
            dial++;
            break;
          default:
        }
        spins--;
        if (dial % 100 == 0) {
          count++;
        }
      }
    }

    return "Count: " + count;
  }
}
