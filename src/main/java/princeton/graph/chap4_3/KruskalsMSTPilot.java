package princeton.graph.chap4_3;

import static princeton.utility.PrintUtil.*;

import java.io.IOException;

public class KruskalsMSTPilot {
  public static void main(String args[]) throws IOException {
    if (args.length == 0) throw new IllegalArgumentException("provide an input graph file");

    EdgeWeightedGraph graph = new EdgeWeightedGraph(args[0]);
    KruskalsMST mst = new KruskalsMST(graph);

    markHeading("KRUSKAL'S minimum spanning tree");
    printLine("graph looks like");
    syso(graph);
    printLine("minimum spanning tree is ");
    for (Edge edge : mst.getMST()) syso(edge);
    syso("with weight " + mst.getWeight());
  }
}
