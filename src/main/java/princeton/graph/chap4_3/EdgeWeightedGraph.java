package princeton.graph.chap4_3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class EdgeWeightedGraph {
  private int tVertex;
  private int tEdge;
  private List<List<Edge>> graph = new ArrayList<>();

  public void EdgeWeightedGraphInit(int totalVertex) {
    tVertex = totalVertex;
    for (int i = 0; i < totalVertex; i++) graph.add(new LinkedList<>());
  }

  public EdgeWeightedGraph(String fileName) throws IOException {
    BufferedReader reader = new BufferedReader(new FileReader(new File(fileName)));
    int totalVertex = Integer.parseInt(reader.readLine());
    EdgeWeightedGraphInit(totalVertex);
    Integer.parseInt(reader.readLine());
    String line;
    while ((line = reader.readLine()) != null) {
      String split[] = line.split(" ");
      addEdge(Integer.parseInt(split[0]), Integer.parseInt(split[1]), Double.parseDouble(split[2]));
    }
    reader.close();
  }

  public void addEdge(int v, int w, double weight) {
    Edge edge = new Edge(v, w, weight);
    graph.get(v).add(edge);
    graph.get(w).add(edge);
    tEdge++;
  }

  public Iterable<Edge> adj(int v) {
    return graph.get(v);
  }

  public Iterable<Edge> edges() {
    LinkedList<Edge> list = new LinkedList<>();
    for (int v = 0; v < getTVertex(); v++) {
      for (Edge edge : graph.get(v)) {
        if (edge.other(v) > v) list.add(edge);
      }
    }
    return list;
  }

  public int getTVertex() {
    return tVertex;
  }

  public int getTEdge() {
    return tEdge;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("vertices : " + this.tVertex + "\t|\tEdges : " + this.tEdge);
    sb.append("\n" + String.format("%50s", " ").replace(" ", "=") + "\n");
    sb.append("S | Destinations with weight");
    sb.append("\n" + String.format("%50s", " ").replace(" ", "=") + "\n");
    for (int v = 0; v < this.tVertex; v++) {
      sb.append(v + "\t|\t");
      for (Edge adj : this.graph.get(v)) sb.append(adj + " ");
      sb.append("\n");
    }
    return sb.toString();
  }
}
