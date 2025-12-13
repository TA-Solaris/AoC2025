package d6.parser;

import java.util.List;

public class Equation {
  public final List<Long> horizontal;
  public final List<Long> vertical;
  public final Character symbol;

  public Equation(List<Long> horizontal, List<Long> vertical, Character symbol) {
    this.horizontal = horizontal;
    this.vertical = vertical;
    this.symbol = symbol;
  }
}
