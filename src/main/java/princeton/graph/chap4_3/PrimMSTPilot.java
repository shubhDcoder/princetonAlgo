package princeton.graph.chap4_3;

import static princeton.utility.PrintUtil.*;

import java.io.IOException;

public class PrimMSTPilot {
  public static void main(String args[]) throws IOException {
    if (args.length == 0) throw new IllegalArgumentException("please provide a graph input file");
    EdgeWeightedGraph graph = new EdgeWeightedGraph(args[0]);
    PrimMST mst = new PrimMST(graph);

    markHeading("PRIMS minimum spanning tree - LAZY approach");
    printLine("graph looks like");
    syso(graph);
    printLine("minimum spanning tree is ");
    for (Edge edge : mst.getMST()) syso(edge);
    syso("with weight -- " + mst.getWeight());
  }
}
