package princeton.graph.chap4_2;

import java.io.IOException;
import java.util.Queue;
import java.util.LinkedList;

import static princeton.utility.PrintUtil.*;

public class DirectedBFS {
    public static void main(String[] args) throws IOException {
        if(args.length == 0) throw new IllegalArgumentException("Please provide a grpah input file");
        DiGraph graph = new DiGraph(args[0]);

        markHeading("Directed BFS");
        printNewLine();
        
        printLine("graph looks like");
        syso(graph.toString());
        DirectedBFS bfs = new DirectedBFS();
        printLine("Directed grpah DFS traversal looks like");
        bfs.callBFS(graph, 0);

        printNewLine();
        printLine("paths from a single source to every other node using DFS");
        bfs.showAllPaths(graph, 0);
    }

    public void showAllPaths(DiGraph graph, int source) {
        DirectedBFSPaths paths = new DirectedBFSPaths(graph, source);

        for(int i = 0; i < graph.getTVertex(); i++) {
            if(paths.hasPath(i)) {
                System.out.print(source + " to " + i + " : ");
                for(int el : paths.getPath(i)) {
                    System.out.print(el == source ? el : ("-" + el));
                }
                printNewLine();
            }
        }
    }

    public void callBFS(DiGraph graph, int source) {
        if(graph.getTVertex() <= source) return;

        byte[] visited = new byte[graph.getTVertex()];
        Queue<Integer> queue = new LinkedList<>();
        String[] shortestPaths = new String[graph.getTVertex()];

        queue.offer(source);
        visited[source] = 1;
        shortestPaths[source] = String.valueOf(source);

        while(!queue.isEmpty()) {
            int size = queue.size();
            while(size-- > 0) {
                int u = queue.poll();
                syso(shortestPaths[u]);
                for(int adj : graph.adj(u)) {
                    if(visited[adj] == 0) {
                        queue.offer(adj);
                        visited[adj] = 1;
                        shortestPaths[adj] = shortestPaths[u] + "-" + adj;
                    }
                }
            }
        }
    }
}