package princeton.graph.chap4_2;

import java.util.Stack;

public class TopologicalSort {

    Stack<Integer> reversePostOrder;

    public TopologicalSort(DiGraph graph) {
        DirectedCycle cycle = new DirectedCycle(graph);

        if(!cycle.hasCycle()) {
            DepthFirstOrder order = new DepthFirstOrder(graph);
            reversePostOrder = order.getReversePostOrder();
        }
    }

    public Stack<Integer> getOrder() {
        return reversePostOrder;
    }

    public boolean isDAG() {
        return reversePostOrder == null;
    }
}