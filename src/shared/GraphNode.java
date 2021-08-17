package shared;

import java.util.ArrayList;
import java.util.List;

public class GraphNode {
    public int val;
    public boolean visited;
    public List<GraphNode> children;
    public GraphNode prev;

    public GraphNode(int x) {
        val = x;
        children = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "GraphNode{" +
                "val=" + val +
                ", visited=" + visited +
                ", prev=" + prev +
                '}';
    }
}
