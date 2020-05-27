package princeton.graph.chap4_3;

import java.util.Arrays;
import java.util.PriorityQueue;

public class PrimMSTEager {
  private Edge[] edgeTo;
  private double[] distTo;
  private boolean[] marked;
  private double weight;
  private PriorityQueue<VertexAtDist> pQueue;

  // replacement for indexMinPriorityQueue
  static class VertexAtDist implements Comparable<VertexAtDist> {
    int vertex;
    double weight;

    public VertexAtDist(int vertex, double weight) {
      this.vertex = vertex;
      this.weight = weight;
    }

    @Override
    public boolean equals(Object obj) {
      VertexAtDist other = (VertexAtDist) obj;
      return this.vertex == other.vertex;
    }

    @Override
    public int compareTo(VertexAtDist other) {
      return Double.compare(this.weight, other.weight);
    }
  }

  public PrimMSTEager(EdgeWeightedGraph graph) {
    edgeTo = new Edge[graph.getTVertex()];
    distTo = new double[graph.getTVertex()];
    marked = new boolean[graph.getTVertex()];
    Arrays.fill(distTo, Integer.MAX_VALUE);
    pQueue = new PriorityQueue<>(graph.getTVertex());

    distTo[0] = 0.0;
    pQueue.offer(new VertexAtDist(0, 0.0));
    while (!pQueue.isEmpty()) {
      VertexAtDist minKnownVertex = pQueue.poll();
      weight += minKnownVertex.weight;
      visit(graph, minKnownVertex.vertex);
    }
  }

  public void visit(EdgeWeightedGraph graph, int v) {
    marked[v] = true;
    for (Edge edge : graph.adj(v)) {
      int w = edge.other(v);
      if (marked[w]) continue;
      if (distTo[w] > edge.weight()) {
        edgeTo[w] = edge;
        distTo[w] = edge.weight();
        VertexAtDist toBeInserted = new VertexAtDist(w, edge.weight());
        if (pQueue.contains(toBeInserted)) {
          pQueue.remove(toBeInserted);
        }
        pQueue.offer(toBeInserted);
      }
    }
  }

  public Iterable<Edge> getMST() {
    return Arrays.asList(Arrays.copyOfRange(edgeTo, 1, edgeTo.length));
  }

  public double getWeight() {
    return weight;
  }
}
