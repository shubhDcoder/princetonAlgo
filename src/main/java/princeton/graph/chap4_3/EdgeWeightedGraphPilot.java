package princeton.graph.chap4_3;

import static princeton.utility.PrintUtil.*;

import java.io.IOException;

public class EdgeWeightedGraphPilot {
  public static void main(String args[]) throws IOException {
    if (args.length == 0) throw new IllegalArgumentException("please provide a graph input file");

    markHeading("graph looks like");
    EdgeWeightedGraph graph = new EdgeWeightedGraph(args[0]);
    syso(graph);

    markHeading("all edges are ");
    for (Edge e : graph.edges()) syso(e);
  }
}
