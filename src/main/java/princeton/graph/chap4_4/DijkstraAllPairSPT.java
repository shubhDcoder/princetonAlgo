package princeton.graph.chap4_4;

public class DijkstraAllPairSPT {
  private DijkstraSPT[] ans;

  public DijkstraAllPairSPT(EdgeWeightedDiGraph graph) {
    ans = new DijkstraSPT[graph.getTVertex()];
    for (int i = 0; i < graph.getTVertex(); i++) {
      ans[i] = new DijkstraSPT(graph, i);
    }
  }

  public Iterable<DirectedEdge> paths(int s, int t) {
    return ans[s].pathTo(t);
  }

  public double dist(int s, int t) {
    return ans[s].distTo(t);
  }

  public boolean hasPath(int s, int t) {
    return ans[s].hasPath(t);
  }
}
