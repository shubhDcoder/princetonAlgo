package princeton.graph.chap4_2;

import java.util.LinkedList;
import java.util.Stack;
import java.util.Queue;

public class DepthFirstOrder {

    boolean[] visited;
    Queue<Integer> preOrder = new LinkedList<>();
    Queue<Integer> postOrder = new LinkedList<>();
    Stack<Integer> reversePostOrder = new Stack<>();

    public DepthFirstOrder(DiGraph graph) {
        visited = new boolean[graph.getTVertex()];
        for(int i = 0; i < graph.getTVertex(); i++) {
            if(visited[i] == false) {
                callDfs(i, graph);
            }
        }
    }

    public void callDfs(int source, DiGraph graph) {
        visited[source] = true;
        preOrder.offer(source);
        for(int adj : graph.adj(source)) {
            if(visited[adj] == false) {
                callDfs(adj, graph);
            }
        }
        postOrder.offer(source);
        reversePostOrder.push(source);
    }

    public Queue<Integer> getPreOrder() {
        return preOrder;
    }

    public Queue<Integer> getPostOrder() {
        return postOrder;
    }

    public Stack<Integer> getReversePostOrder() {
        return reversePostOrder;
    }
}