package d1.parser;

public class Instruction {
  public final char direction;
  public final int value;

  public Instruction(char direction, int value) {
    this.direction = direction;
    this.value = value;
  }
}
