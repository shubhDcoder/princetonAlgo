package princeton.graph.chap4_2;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;

import java.util.List;
import java.util.ArrayList;

public class DiGraph {
    private int tVertex;
    private int tEdge;
    private List<List<Integer>> adjacencyList;

    public void initGraph(int V) {
        tVertex = V;
        adjacencyList = new ArrayList<>(V);
        for(int i = 0; i < V; i++) adjacencyList.add(new ArrayList<>());
    }

    public DiGraph() {}

    public DiGraph(String file) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(new File(file)));
        initGraph(Integer.parseInt(reader.readLine()));
        String line;
        while((line = reader.readLine()) != null) {
            String[] temp = line.split(" ");
            addEdge(Integer.parseInt(temp[0]), Integer.parseInt(temp[1]));
        }
    }

    public void addEdge(int s, int d) {
        adjacencyList.get(s).add(d);
        tEdge++;
    }
    
    public List<Integer> adj(int s) {
        return adjacencyList.get(s);
    }

    public DiGraph reverse() {
        DiGraph newGraph = new DiGraph();
        newGraph.initGraph(tVertex);        
        for(int i = 0; i < tVertex; i++) {
            for(int j : adj(i)) newGraph.addEdge(j, i);
        }
        return newGraph;
    }

    public int getTVertex() { 
        return tVertex;
    }

    public int getTEdges() {
        return tEdge;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("vertices : " + this.tVertex + "\t|\tEdges : " + this.tEdge);
        sb.append("\n" + String.format("%50s", " ").replace(" ", "=") + "\n");
        sb.append("source\tdestination");
        sb.append("\n" + String.format("%50s", " ").replace(" ", "=") + "\n");
        for(int v = 0; v < this.tVertex; v++) {
            sb.append(v + "\t|\t");
            for(int adj : this.adjacencyList.get(v)) sb.append(adj + " ");
            sb.append("\n");
        }
        return sb.toString();
    }
}