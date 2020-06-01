package princeton.graph.chap4_2;

import static princeton.utility.PrintUtil.*;

import java.io.IOException;

public class DirectedCyclePilot {
  public static void main(String args[]) throws IOException {
    markHeading("detection of cycle in a graph using DFS");

    DiGraph graph = new DiGraph(args[0]);

    DirectedCyclePilot pilot = new DirectedCyclePilot();
    pilot.checkForCycle(graph);
  }

  public void checkForCycle(DiGraph graph) {
    DirectedCycle cycleD = new DirectedCycle(graph);
    if (cycleD.hasCycle()) {
      syso("cycle detected !");
      while (cycleD.getCycle().size() > 1) {
        int popped = cycleD.getCycle().pop();
        System.out.print(popped + "-");
      }
      System.out.print(cycleD.getCycle().pop());
      printNewLine();
    } else {
      syso("No cycle detected");
    }
  }
}
