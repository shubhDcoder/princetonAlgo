package princeton.graph.chap4_2;

public class KosaRajuSCC {
  boolean[] visited;
  int[] compId;
  int totalComponents;

  public KosaRajuSCC(DiGraph graph) {
    DiGraph reversedGraph = graph.reverse();
    DepthFirstOrder order = new DepthFirstOrder(reversedGraph);

    compId = new int[graph.getTVertex()];
    visited = new boolean[graph.getTVertex()];

    for (int vertx : order.getReversePostOrder()) {
      if (visited[vertx] == false) {
        callDFS(vertx, graph);
        totalComponents++;
      }
    }
  }

  public void callDFS(int source, DiGraph graph) {
    visited[source] = true;
    compId[source] = totalComponents;
    for (int adj : graph.adj(source)) {
      if (visited[adj] == false) callDFS(adj, graph);
    }
  }

  public int getTotalComponents() {
    return totalComponents;
  }

  public boolean inSameComponent(int u, int v) {
    return compId[u] == compId[v];
  }

  public int getCompId(int key) {
    return compId[key];
  }
}
