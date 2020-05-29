package princeton.graph.chap4_4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class EdgeWeightedDiGraph {
  private int tVertex;
  private int tEdge;
  private List<List<DirectedEdge>> adjcencyList;

  public EdgeWeightedDiGraph(String fileName) throws IOException {
    BufferedReader reader = new BufferedReader(new FileReader(new File(fileName)));
    int totalVertex = Integer.parseInt(reader.readLine());
    int totalEdge = Integer.parseInt(reader.readLine());
    init(totalVertex, totalEdge);
    String line;
    while ((line = reader.readLine()) != null) {
      String[] split = line.split(" ");
      addEdge(Integer.parseInt(split[0]), Integer.parseInt(split[1]), Double.parseDouble(split[2]));
    }
    reader.close();
  }

  public void init(int totalVertex, int totalEdge) {
    adjcencyList = new ArrayList<>(totalVertex);
    for (int i = 0; i < totalVertex; i++) adjcencyList.add(new LinkedList<>());
    tVertex = totalVertex;
    tEdge = totalEdge;
  }

  private void addEdge(int source, int destination, double weight) {
    DirectedEdge edge = new DirectedEdge(source, destination, weight);
    adjcencyList.get(source).add(edge);
  }

  public int getTVertex() {
    return tVertex;
  }

  public int getTEdge() {
    return tEdge;
  }

  public Iterable<DirectedEdge> adj(int source) {
    return adjcencyList.get(source);
  }

  public Iterable<DirectedEdge> edges() {
    LinkedList<DirectedEdge> list = new LinkedList<>();
    for (int i = 0; i < getTVertex(); i++) for (DirectedEdge edge : adj(i)) list.add(edge);
    return list;
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
      for (DirectedEdge adj : adj(v)) sb.append(adj + " ");
      sb.append("\n");
    }
    return sb.toString();
  }
}
