package d2;

import java.util.List;
import java.util.ArrayList;
import utils.Runner;
import d2.parser.*;

public class D2P2 implements Runner {

  @Override
  public String run(String input) {
    var ranges = Parser.parse(input);
    long sum = 0;

    long maxRange = ranges.stream()
        .mapToLong(r -> r.upper)
        .max()
        .orElse(0);
    List<Long> repetitions = GetRepetitions(maxRange); // Bruteforce

    for (ProductRange range : ranges) {
      sum += GetCount(range.upper, repetitions) - GetCount(range.lower - 1, repetitions);
    }

    return "Sum: " + sum;
  }

  private long GetCount(long max, List<Long> repetitions) {
    return repetitions.stream()
        .filter(x -> x <= max)
        .mapToLong(Long::longValue)
        .sum();
  }

  private List<Long> GetRepetitions(long maxSize) {
    List<Long> result = new ArrayList<>();

    for (long n = 1; n <= maxSize; n++) {
      String s = Long.toString(n);
      int len = s.length();

      for (int chunkSize = 1; chunkSize <= len / 2; chunkSize++) {
        if (len % chunkSize != 0)
          continue;

        String chunk = s.substring(0, chunkSize);
        int repeatCount = len / chunkSize;

        StringBuilder rebuilt = new StringBuilder(len);
        for (int i = 0; i < repeatCount; i++) {
          rebuilt.append(chunk);
        }

        if (rebuilt.toString().equals(s)) {
          result.add(n);
          break;
        }
      }
    }

    return result;
  }
}
