package d2.parser;

public class ProductRange {
  public final long lower;
  public final long upper;
  public final long start; // This value isn't guarenteed to be > lower

  public ProductRange(long lower, long upper, long start) {
    this.lower = lower;
    this.upper = upper;
    this.start = start;
  }
}
