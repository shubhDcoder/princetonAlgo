package princeton.graph.chap4_2;

public class TopologicalSort {

    Iterable<Integer> reversePostOrder;

    public TopologicalSort(DiGraph graph) {
        DirectedCycle cycle = new DirectedCycle(graph);

        if(!cycle.hasCycle()) {
            DepthFirstOrder order = new DepthFirstOrder(graph);
            reversePostOrder = order.getReversePostOrder();
        }
    }

    public Iterable<Integer> getOrder() {
        return reversePostOrder;
    }

    public boolean isDAG() {
        return reversePostOrder == null;
    }
}