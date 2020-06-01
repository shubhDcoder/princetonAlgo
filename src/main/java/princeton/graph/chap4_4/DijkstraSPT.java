package princeton.graph.chap4_4;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class DijkstraSPT {

  private static class ToVertex implements Comparable<ToVertex> {
    private double weight;
    private int to;

    public ToVertex(int to, double weight) {
      this.to = to;
      this.weight = weight;
    }

    @Override
    public boolean equals(Object obj) {
      ToVertex other = (ToVertex) obj;
      return this.to == other.to;
    }

    @Override
    public int compareTo(ToVertex other) {
      return Double.compare(this.weight, other.weight);
    }
  }

  private DirectedEdge[] edgeTo;
  private double[] distTo;
  PriorityQueue<ToVertex> pQueue;

  public DijkstraSPT(EdgeWeightedDiGraph graph, int source) {
    pQueue = new PriorityQueue<>();
    edgeTo = new DirectedEdge[graph.getTVertex()];
    distTo = new double[graph.getTVertex()];
    Arrays.fill(distTo, Double.MAX_VALUE);
    // logic to calculate SPT
    distTo[source] = 0.0;
    pQueue.add(new ToVertex(source, 0.0));
    while (pQueue.isEmpty() == false) {
      relax(graph, pQueue.poll().to);
    }
  }

  private void relax(EdgeWeightedDiGraph graph, int to) {
    for (DirectedEdge edge : graph.adj(to)) {
      double tDist = distTo[to] + edge.weight();
      int toV = edge.to();
      if (distTo[toV] > tDist) {
        distTo[toV] = tDist;
        edgeTo[toV] = edge;
        ToVertex toBeAdded = new ToVertex(toV, tDist);
        if (pQueue.contains(toBeAdded)) pQueue.remove(toBeAdded);
        pQueue.add(toBeAdded);
      }
    }
  }

  public boolean hasPath(int v) {
    return distTo[v] != Double.MAX_VALUE;
  }

  public double distTo(int v) {
    return distTo[v];
  }

  public Iterable<DirectedEdge> pathTo(int v) {
    if (hasPath(v) == false) return null;
    Deque<DirectedEdge> stack = new LinkedList<>();
    for (DirectedEdge e = edgeTo[v]; e != null; e = edgeTo[e.from()]) stack.push(e);
    return stack;
  }
}
