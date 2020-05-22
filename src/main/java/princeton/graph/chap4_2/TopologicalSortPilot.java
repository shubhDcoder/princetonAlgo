package princeton.graph.chap4_2;

import java.io.IOException;

public class TopologicalSortPilot {

    public static void main(String args[]) throws IOException {
        SymbolDigraph graph = new SymbolDigraph(args[0], "/");

        TopologicalSort topSort = new TopologicalSort(graph.getGraph());

        Iterable<Integer> order = topSort.getOrder();
        if(order != null) {
            for(Integer i : order) {
                System.out.println(graph.getKey(i));
            }
        }
    }
}