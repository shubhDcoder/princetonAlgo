package princeton.graph.chap4_2;

import java.util.Queue;
import java.util.LinkedList;

import static princeton.utility.PrintUtil.*;

public class DirectedBFSPaths {
    byte[] visited;
    int[] parent;
    int source;
    
    public DirectedBFSPaths(DiGraph graph, int source) {
        visited = new byte[graph.getTVertex()];
        parent = new int[graph.getTVertex()];
        this.source = source;
        callBFS(graph, source);
    }

    public void callBFS(DiGraph graph, int source) {
        if(source >= graph.getTVertex()) {
            syso("no vertex exists with id " + source);
            return;
        }

        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(source);
        visited[source] = 1;
        
        while(!queue.isEmpty()) {
            int u = queue.poll();
            for(int adj : graph.adj(u)) {
                if(visited[adj] == 0) {
                    queue.offer(adj);
                    visited[adj] = 1;
                    parent[adj] = u;
                }
            }
        }
    }

    public boolean hasPath(int dest) {
        return visited[dest] == 1;
    }

    public LinkedList<Integer> getPath(int dest) {
        LinkedList<Integer> list = new LinkedList<>();
        for(int x = dest; x != source; x = parent[x]) list.addFirst(x);
        list.addFirst(source);
        return list;
    }
}