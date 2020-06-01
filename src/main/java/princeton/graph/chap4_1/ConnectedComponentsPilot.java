package princeton.graph.chap4_1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConnectedComponentsPilot {
  public static void main(String args[]) throws FileNotFoundException {
    if (args.length == 0) throw new IllegalArgumentException("Please provide an input file");

    // constructing graph
    Scanner scanner = new Scanner(new File(args[0]));
    Graph graph = new Graph(scanner);
    scanner.close();

    // preparing needed variables
    int src = (args.length > 1) ? Integer.parseInt(args[1]) : 0;

    PrintUtil.markHeading("Connected Components using DFS");
    PrintUtil.printLine("graph looks like");
    PrintUtil.syso(graph);

    PrintUtil.markHeading("Connected components are : ");
    ConnectedComponentsPilot pilot = new ConnectedComponentsPilot();
    pilot.showConnectedComponents(graph, src);
  }

  public void showConnectedComponents(Graph graph, int source) {
    ConnectedComponents cc = new ConnectedComponents(graph, source);
    List<List<Integer>> result = new ArrayList<>(cc.count);

    for (int i = 0; i < cc.count; i++) result.add(new ArrayList<>());

    for (int i = 0; i < graph.tVertex; i++) result.get(cc.componentId[i]).add(i);

    for (int i = 0; i < cc.count; i++) {
      PrintUtil.syso("component id " + i);
      PrintUtil.syso("\t" + result.get(i));
    }
  }
}
