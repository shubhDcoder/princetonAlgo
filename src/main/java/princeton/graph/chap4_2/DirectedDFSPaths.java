package princeton.graph.chap4_2;

import java.util.LinkedList;

public class DirectedDFSPaths {
    boolean visited[];
    int parent[];
    int source;
    public DirectedDFSPaths(DiGraph graph, int source) {
        visited = new boolean[graph.getTVertex()];
        parent = new int[graph.getTVertex()];        
        this.source = source;
        callDfs(source, graph);
    }

    public void callDfs(int s, DiGraph graph) {
        visited[s] = true;
        for(int adj : graph.adj(s)) {
            if(visited[adj] == false) {
                callDfs(adj, graph);
                parent[adj] = s;
            }
        }
    }

    public boolean hasPath(int dest) {
        return visited[dest];
    }

    public LinkedList<Integer> getPath(int dest) {
        LinkedList<Integer> list = new LinkedList<>();
        for(int x = dest; x != source; x = parent[x]) {
            list.addFirst(x);
        }
        list.addFirst(source);
        return list;
    }
}