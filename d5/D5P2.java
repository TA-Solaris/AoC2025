package d5;

import utils.Runner;
import utils.Pair;
import d5.parser.*;
import java.util.List;
import java.util.ArrayList;

import java.util.Collections;

public class D5P2 implements Runner {

  @Override
  public String run(String input) {
    var inventory = Parser.parse(input);
    long sum = 0;

    List<Pair<Long, Long>> ranges = mergeRanges(inventory.ranges);

    for (Pair<Long, Long> range : ranges) {
      // Add one as we include both bounds
      // System.out.println(range.getFirst() + "-" + range.getSecond());
      sum += range.getSecond() - range.getFirst() + 1;
    }

    return "Sum: " + sum;
  }

  private List<Pair<Long, Long>> mergeRanges(List<Pair<Long, Long>> ranges) {
    ranges.sort((a, b) -> Long.compare(a.getFirst(), b.getFirst()));

    List<Pair<Long, Long>> merged = new ArrayList<>();

    long currentStart = ranges.get(0).getFirst();
    long currentEnd = ranges.get(0).getSecond();

    for (int i = 1; i < ranges.size(); i++) {
      long nextStart = ranges.get(i).getFirst();
      long nextEnd = ranges.get(i).getSecond();

      if (nextStart <= currentEnd) {
        currentEnd = Math.max(currentEnd, nextEnd);
      } else {
        merged.add(new Pair<>(currentStart, currentEnd));
        currentStart = nextStart;
        currentEnd = nextEnd;
      }
    }

    merged.add(new Pair<>(currentStart, currentEnd));

    return merged;
  }
}
