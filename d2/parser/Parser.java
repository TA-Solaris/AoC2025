package d2.parser;

import java.util.ArrayList;
import java.util.List;

public class Parser {

  public static List<ProductRange> parse(String input) {
    List<ProductRange> list = new ArrayList<>();

    String cleanInput = input.replaceAll("\\s+", "");
    String[] ranges = cleanInput.split(",");

    for (String range : ranges) {
      if (range.isBlank())
        continue;

      String[] parts = range.split("-");

      long lower = Long.parseLong(parts[0]);
      long upper = Long.parseLong(parts[1]);
      long start = GetStartValue(parts[0]);

      list.add(new ProductRange(lower, upper, start));
    }

    return list;
  }

  private static long GetStartValue(String lower) {
    if (lower.length() % 2 == 1) {
      return (long) Math.pow(10, lower.length() / 2);
    }
    return Long.parseLong(lower.substring(0, lower.length() / 2));
  }
}
