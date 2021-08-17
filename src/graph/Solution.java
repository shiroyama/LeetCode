package graph;

import shared.GraphNode;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        GraphNode root = init();
        Deque<GraphNode> queue = new ArrayDeque<>();
        queue.add(root);
        List<Integer> distance = new ArrayList<>();
        int[] dist = new int[6];
        while (!queue.isEmpty()) {
            GraphNode node = queue.remove();
            if (node.val == 4) {
                List<Integer> route = new ArrayList<>();
                route.add(node.val);
                while (node.prev != null) {
                    GraphNode temp = node.prev;
                    route.add(temp.val);
                    node.prev = node.prev.prev;
                }
                System.out.println(route);
            }
            if (!node.visited) {
                // System.out.println("Node: " + node.val);
                System.out.println(node);
                node.visited = true;
            }
            for (GraphNode child : node.children) {
                if (child.visited) {
                    continue;
                }
                child.prev = node;
                int nextCandidate = dist[node.val] + 1;
                if (child.val > 0 && child.val < nextCandidate) continue;
                dist[child.val] = nextCandidate;
                queue.add(child);
            }
        }
        System.out.println(Arrays.toString(dist));
    }

    private static GraphNode init() {
        GraphNode node0 = new GraphNode(0);
        GraphNode node1 = new GraphNode(1);
        GraphNode node2 = new GraphNode(2);
        GraphNode node3 = new GraphNode(3);
        GraphNode node4 = new GraphNode(4);
        GraphNode node5 = new GraphNode(5);

        {
            node0.children.add(node1);
            node0.children.add(node4);
            node0.children.add(node5);
        }

        {
            node1.children.add(node0);
            node1.children.add(node2);
            node1.children.add(node3);
            node1.children.add(node4);
        }

        {
            node2.children.add(node1);
            node2.children.add(node3);
        }

        {
            node3.children.add(node1);
            node3.children.add(node2);
            node3.children.add(node4);
        }

        {
            node4.children.add(node0);
            node4.children.add(node1);
            node4.children.add(node3);
        }

        {
            node5.children.add(node0);
        }
        return node0;
    }
}
