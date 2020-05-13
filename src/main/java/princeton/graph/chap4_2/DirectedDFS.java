package princeton.graph.chap4_2;

import java.io.IOException;

import static princeton.utility.PrintUtil.*;

public class DirectedDFS {
    boolean[] visited;
    public static void main(String args[]) throws IOException {
        if(args.length == 0) throw new IllegalArgumentException("Please provide a input graph file");

        markHeading("Directed DFS");
        printNewLine();
        
        DiGraph graph = new DiGraph(args[0]);
        printLine("graph looks like");
        syso(graph.toString());
        DirectedDFS dfs = new DirectedDFS();
        printLine("Directed grpah DFS traversal looks like");
        dfs.callDfs(graph);

        // DiGraph reversed = graph.reverse();
        // printLine("Reversed graph looks like");
        // syso(reversed.toString());
        // printLine("REVERSED Directed grpah DFS traversal looks like");
        // dfs.callDfs(reversed);
        printNewLine();
        printLine("paths from a single source to every other node using DFS");
        dfs.showAllPaths(graph, 0);
    }

    public void showAllPaths(DiGraph graph, int source) {
        DirectedDFSPaths paths = new DirectedDFSPaths(graph, source);
        for(int i = 0; i < graph.getTVertex(); i++) {
            if(paths.hasPath(i)) {
                System.out.print(source + " to " + i + " : ");
                for(int item : paths.getPath(i)) {
                    System.out.print(item == source ? item : "-" + item);
                };
                printNewLine();
            }
        }
    }

    public void callDfs(DiGraph graph) {
        visited = new boolean[graph.getTVertex()];
        for(int i = 0; i < graph.getTVertex(); i++) {
            if(visited[i] == false) {
                callDfs(i, String.valueOf(i), graph);
            }
            
        }
    }

    public void callDfs(int source, String callStack, DiGraph graph) {
        visited[source] = true;
        syso(callStack);
        for(int adj : graph.adj(source)) {
            if(visited[adj] == false) {
                callDfs(adj, callStack + "\t" + adj, graph);
            }
        }
    }
}