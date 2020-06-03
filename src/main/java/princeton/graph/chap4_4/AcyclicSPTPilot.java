package princeton.graph.chap4_4;

import static princeton.utility.PrintUtil.*;

import java.io.IOException;

public class AcyclicSPTPilot {
  public static void main(String[] args) throws IOException {
    if (args.length == 0) throw new IllegalArgumentException("please provide an input graph file");
    EdgeWeightedDiGraph graph = new EdgeWeightedDiGraph(args[0]);
    AcyclicSPT spt = new AcyclicSPT(graph, 5);

    for (int i = 0; i < graph.getTVertex(); i++) {
      System.out.printf("SP from %-2d to %-2d ", 5, i);
      if (spt.hasPath(i)) {
        System.out.printf("@ %-2.2f : ", spt.dist(i));
        spt.getPath(i).forEach((e) -> System.out.print(e + " "));
      }
      printNewLine();
    }
  }
}
