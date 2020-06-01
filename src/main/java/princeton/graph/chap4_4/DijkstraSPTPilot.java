package princeton.graph.chap4_4;

import static princeton.utility.PrintUtil.*;

import java.io.IOException;

public class DijkstraSPTPilot {
  public static void main(String[] args) throws IOException {
    if (args.length == 0) throw new IllegalArgumentException("please provide a graph input file");
    EdgeWeightedDiGraph graph = new EdgeWeightedDiGraph(args[0]);
    DijkstraSPT spt = new DijkstraSPT(graph, 0);
    for (int i = 0; i < graph.getTVertex(); i++) {
      if (spt.hasPath(i)) {
        System.out.print("path from " + 0 + " to " + i + " : ");
        for (DirectedEdge e : spt.pathTo(i)) System.out.print(e + " ");
        printNewLine();
      }
    }
  }
}
