import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import d1.D1P1;
import d1.D1P2;
import d2.D2P1;
import d2.D2P2;
import d3.D3P1;
import d3.D3P2;
import utils.Runner;

public class Main {

  private static final Map<String, Runner> RUNNERS = Map.ofEntries(
      Map.entry("D1P1", new D1P1()),
      Map.entry("D1P2", new D1P2()),
      Map.entry("D2P1", new D2P1()),
      Map.entry("D2P2", new D2P2()),
      Map.entry("D3P1", new D3P1()),
      Map.entry("D3P2", new D3P2()));

  public static void main(String[] args) throws Exception {
    if (args.length != 2) {
      System.out.println("Usage: java Main <DxPx> <inputfile>");
      return;
    }

    String key = args[0].toUpperCase();
    String filePath = args[1];

    Runner runner = RUNNERS.get(key);
    if (runner == null) {
      System.out.println("No runner found for key: " + key);
      return;
    }

    String input = Files.readString(Paths.get(filePath));

    String result = runner.run(input);
    System.out.println(result);
  }
}
