package _102_binary_tree_level_order_traversal;

import shared.TreeNode;
import shared.Utils;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        TreeNode root = Utils.makeTree(new Integer[]{
                3, 9, 20, null, null, 15, 7
        });
        List<List<Integer>> lists = new Solution().levelOrder(root);
        System.out.println(lists);
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        NodeWithDepth top = new NodeWithDepth(root, 1);
        Deque<NodeWithDepth> queue = new ArrayDeque<>();
        queue.push(top);
        Map<Integer, List<Integer>> depthToList = new HashMap<>();
        while (!queue.isEmpty()) {
            NodeWithDepth node = queue.poll();
            List<Integer> list = depthToList.getOrDefault(node.depth, new ArrayList<>());
            list.add(node.node.val);
            depthToList.put(node.depth, list);
            if (node.node.left != null) queue.offer(new NodeWithDepth(node.node.left, node.depth + 1));
            if (node.node.right != null) queue.offer(new NodeWithDepth(node.node.right, node.depth + 1));
        }
        List<Map.Entry<Integer, List<Integer>>> entryList = new ArrayList<>(depthToList.entrySet());
        Collections.sort(entryList, (left, right) -> left.getKey() - right.getKey());
        result = entryList.stream().map(Map.Entry::getValue).collect(Collectors.toList());
        return result;
    }

    class NodeWithDepth {
        final TreeNode node;
        final int depth;

        NodeWithDepth(TreeNode node, int depth) {
            this.node = node;
            this.depth = depth;
        }
    }
}
