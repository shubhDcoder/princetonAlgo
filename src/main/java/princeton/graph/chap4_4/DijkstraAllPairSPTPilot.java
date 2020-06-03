package princeton.graph.chap4_4;

import static princeton.utility.PrintUtil.*;

import java.io.IOException;

public class DijkstraAllPairSPTPilot {
  public static void main(String args[]) throws IOException {
    if (args.length == 0) throw new IllegalArgumentException("please provide a graph input file");
    EdgeWeightedDiGraph graph = new EdgeWeightedDiGraph(args[0]);
    DijkstraAllPairSPT allPairs = new DijkstraAllPairSPT(graph);

    for (int i = 0; i < graph.getTVertex(); i++) {
      syso("Shortest path from " + i);
      for (int j = 0; j < graph.getTVertex(); j++) {
        if (allPairs.hasPath(i, j)) {
          System.out.print(" to " + j + " : ");
          allPairs.paths(i, j).forEach((e) -> System.out.print(e + " "));
          System.out.printf("with weight @ %-2.2f", allPairs.dist(i, j));
          printNewLine();
        }
      }
      printNewLine();
    }
  }
}
