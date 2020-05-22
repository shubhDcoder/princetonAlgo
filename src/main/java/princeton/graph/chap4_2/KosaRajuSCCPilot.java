package princeton.graph.chap4_2;

import static princeton.utility.PrintUtil.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class KosaRajuSCCPilot {
  public static void main(String[] args) throws IOException {
    if (args.length == 0) throw new IllegalArgumentException("please provide a graph input file");

    markHeading("KOSARAJU Algo");
    printLine();
    syso(
        "Time proportional to 2 * (V + E) and again V for visited, V for compId, V + E for"
            + " reversed Graph. Space proportional to (V + E)");
    printLine();

    DiGraph graph = new DiGraph(args[0]);

    KosaRajuSCC scc = new KosaRajuSCC(graph);

    syso("total comps are " + scc.getTotalComponents());

    List<List<Integer>> comps = new ArrayList<>(scc.getTotalComponents());
    for (int i = 0; i < scc.getTotalComponents(); i++) comps.add(new ArrayList<>());
    for (int i = 0; i < graph.getTVertex(); i++) {
      comps.get(scc.getCompId(i)).add(i);
    }

    int count = 0;
    for (List<Integer> comp : comps) {
      syso("comp id " + (count++) + " : " + comp);
    }
  }
}
