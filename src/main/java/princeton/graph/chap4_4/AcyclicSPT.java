package princeton.graph.chap4_4;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class AcyclicSPT {
  private DirectedEdge[] edgeTo;
  private double[] distTo;
  private boolean[] visited;
  Deque<Integer> reversePostOrder;

  public AcyclicSPT(EdgeWeightedDiGraph graph, int source) {
    edgeTo = new DirectedEdge[graph.getTVertex()];
    reversePostOrder = new LinkedList<>();
    visited = new boolean[graph.getTVertex()];
    distTo = new double[graph.getTVertex()];
    Arrays.fill(distTo, Double.MAX_VALUE);
    getTopSort(graph);

    distTo[source] = 0.0;
    boolean found = false;
    for (int to : reversePostOrder) {
      if (to == source) found = true;
      if (found) relax(to, graph);
    }
  }

  private void relax(int to, EdgeWeightedDiGraph graph) {
    for (DirectedEdge edge : graph.adj(to)) {
      int w = edge.to();
      double dist = distTo[to] + edge.weight();
      if (distTo[w] > dist) {
        distTo[w] = dist;
        edgeTo[w] = edge;
      }
    }
  }

  public boolean hasPath(int t) {
    return distTo[t] != Double.MAX_VALUE;
  }

  public double dist(int t) {
    return distTo[t];
  }

  public Iterable<DirectedEdge> getPath(int t) {
    if (hasPath(t) == false) return null;
    Deque<DirectedEdge> stack = new LinkedList<>();
    for (DirectedEdge edge = edgeTo[t]; edge != null; edge = edgeTo[edge.from()]) stack.push(edge);
    return stack;
  }

  private void getTopSort(EdgeWeightedDiGraph graph) {
    for (int i = 0; i < graph.getTVertex(); i++) {
      if (visited[i] == false) {
        calLDfs(i, graph);
      }
    }
  }

  private void calLDfs(int source, EdgeWeightedDiGraph graph) {
    visited[source] = true;
    for (DirectedEdge edge : graph.adj(source)) {
      if (visited[edge.to()] == false) {
        calLDfs(edge.to(), graph);
      }
    }
    reversePostOrder.push(source);
  }
}
