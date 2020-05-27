package princeton.graph.chap4_3;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class PrimMST {
  private boolean marked[];
  private PriorityQueue<Edge> pQueue;
  private Queue<Edge> queue;
  private double weight;

  public PrimMST(EdgeWeightedGraph graph) {
    marked = new boolean[graph.getTVertex()];
    pQueue = new PriorityQueue<>();
    queue = new LinkedList<>();

    visit(graph, 0);
    while (!pQueue.isEmpty()) {
      Edge removed = pQueue.poll();
      int v = removed.either();
      int w = removed.other(v);
      if (marked[v] && marked[w]) continue;
      queue.offer(removed);
      weight = weight + removed.weight();
      if (marked[v] == false) visit(graph, v);
      if (marked[w] == false) visit(graph, w);
    }
  }

  private void visit(EdgeWeightedGraph graph, int v) {
    marked[v] = true;
    for (Edge edge : graph.adj(v)) {
      int w = edge.other(v);
      if (marked[w] == false) pQueue.offer(edge);
    }
  }

  public Iterable<Edge> getMST() {
    return queue;
  }

  public double getWeight() {
    return weight;
  }
}
