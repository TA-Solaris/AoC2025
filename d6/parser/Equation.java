package d6.parser;

import java.util.List;

public class Equation {
  public final List<Long> horizontal;
  public final Character symbol;

  public Equation(List<Long> horizontal, Character symbol) {
    this.horizontal = horizontal;
    this.symbol = symbol;
  }
}
