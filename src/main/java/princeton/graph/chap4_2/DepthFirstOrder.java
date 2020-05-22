package princeton.graph.chap4_2;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class DepthFirstOrder {

  boolean[] visited;
  Queue<Integer> preOrder = new LinkedList<>();
  Queue<Integer> postOrder = new LinkedList<>();
  Deque<Integer> reversePostOrder = new LinkedList<>();

  public DepthFirstOrder(DiGraph graph) {
    visited = new boolean[graph.getTVertex()];
    for (int i = 0; i < graph.getTVertex(); i++) {
      if (visited[i] == false) {
        callDfs(i, graph);
      }
    }
  }

  public void callDfs(int source, DiGraph graph) {
    visited[source] = true;
    preOrder.offer(source);
    for (int adj : graph.adj(source)) {
      if (visited[adj] == false) {
        callDfs(adj, graph);
      }
    }
    postOrder.offer(source);
    reversePostOrder.addFirst(source);
  }

  public Iterable<Integer> getPreOrder() {
    return preOrder;
  }

  public Iterable<Integer> getPostOrder() {
    return postOrder;
  }

  public Iterable<Integer> getReversePostOrder() {
    return reversePostOrder;
  }
}
