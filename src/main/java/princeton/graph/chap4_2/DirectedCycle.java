package princeton.graph.chap4_2;

import java.util.Stack;

public class DirectedCycle {

    Stack<Integer> stack = null;
    byte[] visited;
    byte[] onStack;
    int[] parent;
    boolean hasCycle;

    public DirectedCycle(DiGraph graph) {
        int N = graph.getTVertex();
        visited = new byte[N];
        onStack = new byte[N];
        parent = new int[N];

        for(int i = 0; i < N; i++) {
            if(visited[i] == 0) {
                checkCycle(i, graph);
            }
        }    
    }

    public void checkCycle(int source, DiGraph graph) {
        visited[source] = 1;
        onStack[source] = 1;
        for(int adj : graph.adj(source)) {
            if(hasCycle) break;
            if(visited[adj] == 0) {
                parent[adj] = source;
                checkCycle(adj, graph);
            } else if(onStack[adj] == 1) {
                hasCycle = true;
                stack = new Stack<>();
                for(int x = source; x != adj; x = parent[x]) {
                    stack.push(x);
                }
                stack.push(adj);
                stack.push(source);
            }
        }
        onStack[source] = 0;
    }

    public boolean hasCycle() {
        return hasCycle;
    }

    public Stack<Integer> getCycle() {
        return stack;
    }
}