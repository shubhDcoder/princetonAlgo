package princeton.graph.chap4_1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BiPartitePilot {
  public static void main(String args[]) throws FileNotFoundException {
    if (args.length == 0) throw new IllegalArgumentException("Please provide an input file");

    // constructing graph
    Scanner scanner = new Scanner(new File(args[0]));
    Graph graph = new Graph(scanner);
    scanner.close();

    PrintUtil.markHeading("is BiPartite using BFS");
    PrintUtil.printLine("graph looks like");
    PrintUtil.syso(graph);

    PrintUtil.markHeading("is BiPartite : " + new BiPartite(graph).isBipartite());
  }
}
