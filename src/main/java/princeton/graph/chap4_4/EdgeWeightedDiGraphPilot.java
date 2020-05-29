package princeton.graph.chap4_4;

import static princeton.utility.PrintUtil.*;

import java.io.IOException;

public class EdgeWeightedDiGraphPilot {
  public static void main(String args[]) throws IOException {
    if (args.length == 0) throw new IllegalArgumentException("please provide a graph input file");

    markHeading("graph looks like");
    EdgeWeightedDiGraph graph = new EdgeWeightedDiGraph(args[0]);
    syso(graph);

    markHeading("all edges are ");
    for (DirectedEdge e : graph.edges()) syso(e);
  }
}
