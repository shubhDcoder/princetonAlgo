package princeton.graph.chap4_3;

import static princeton.utility.PrintUtil.*;

import java.io.IOException;

public class PrimMSTEagerPilot {
  public static void main(String args[]) throws IOException {
    if (args.length == 0) throw new IllegalArgumentException("please provide a graph input file");
    EdgeWeightedGraph graph = new EdgeWeightedGraph(args[0]);
    PrimMSTEager mst = new PrimMSTEager(graph);

    markHeading("PRIMS minimum spanning tree - EAGER approach");
    printLine("graph looks like");
    syso(graph);
    printLine("minimum spanning tree is ");

    for (Edge edge : mst.getMST()) syso(edge);
    syso("with weight : " + mst.getWeight());
  }
}
