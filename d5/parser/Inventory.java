package d5.parser;

import java.util.List;
import utils.Pair;

public class Inventory {
  public final List<Pair<Long, Long>> ranges;
  public final List<Long> ids;

  public Inventory(List<Pair<Long, Long>> ranges, List<Long> ids) {
    this.ranges = ranges;
    this.ids = ids;
  }
}
