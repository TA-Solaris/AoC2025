package d5.parser;

import java.util.ArrayList;
import java.util.List;
import utils.Pair;

public class Parser {

  public static Inventory parse(String input) {
    List<Pair<Long, Long>> ranges = new ArrayList<>();
    List<Long> ids = new ArrayList<>();
    String[] parts = input.split("\\R\\R");
    String[] rangeRows = parts[0].split("\\R");
    String[] idRows = parts[1].split("\\R");

    for (String row : rangeRows) {
      if (row.isBlank())
        continue;

      String[] rangeParts = row.split("-");
      Long lower = Long.parseLong(rangeParts[0]);
      Long upper = Long.parseLong(rangeParts[1]);

      ranges.add(new Pair<Long, Long>(lower, upper));
    }

    for (String row : idRows) {
      if (row.isBlank())
        continue;

      ids.add(Long.parseLong(row));
    }

    return new Inventory(ranges, ids);
  }
}
