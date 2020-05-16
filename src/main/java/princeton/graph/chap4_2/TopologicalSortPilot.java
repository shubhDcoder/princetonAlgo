package princeton.graph.chap4_2;

import java.io.IOException;
import java.util.Stack;

public class TopologicalSortPilot {

    public static void main(String args[]) throws IOException {
        SymbolDigraph graph = new SymbolDigraph(args[0], "/");

        TopologicalSort topSort = new TopologicalSort(graph.getGraph());

        Stack<Integer> order = topSort.getOrder();
        if(order != null) {
            while(order.size() > 0) {
                System.out.println(graph.getKey(order.pop()));
            }
        }
    }
}