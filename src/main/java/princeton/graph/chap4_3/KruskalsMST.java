package princeton.graph.chap4_3;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class KruskalsMST {

  private Queue<Edge> mst = new LinkedList<>();
  private double weight;

  public KruskalsMST(EdgeWeightedGraph graph) {
    LinkedList<Edge> edges = new LinkedList<>();
    graph.edges().forEach(edges::add);
    PriorityQueue<Edge> pQueue = new PriorityQueue<>(edges);
    DisjointSet uf = new DisjointSet(graph.getTVertex());
    while (!pQueue.isEmpty() && mst.size() < graph.getTVertex() - 1) {
      Edge removed = pQueue.poll();
      int v = removed.either();
      int w = removed.other(v);
      if (uf.isConnected(v, w)) continue;
      uf.union(v, w);
      mst.offer(removed);
      weight += removed.weight();
    }
  }

  public Iterable<Edge> getMST() {
    return mst;
  }

  public double getWeight() {
    return weight;
  }
}

class DisjointSet {
  int parent[];
  int size[];

  public DisjointSet(int totalElements) {
    parent = new int[totalElements];
    size = new int[totalElements];
    for (int i = 0; i < totalElements; i++) parent[i] = i;
  }

  public boolean isConnected(int key1, int key2) {
    return find(key1) == find(key2);
  }

  public int find(int key) {
    if (parent[key] != key) parent[key] = find(parent[key]);
    return parent[key];
  }

  public void union(int key1, int key2) {
    int p1 = find(key1);
    int p2 = find(key2);

    if (p1 == p2) return;
    if (size[p1] > size[p2]) {
      parent[p2] = p1;
      size[p1] += size[p2];
    } else {
      parent[p1] = p2;
      size[p2] += size[p1];
    }
  }
}
