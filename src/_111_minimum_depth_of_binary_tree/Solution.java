package _111_minimum_depth_of_binary_tree;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3) {
            {
                left = new TreeNode(9);
                right = new TreeNode(20) {
                    {
                        left = new TreeNode(15);
                        right = new TreeNode(7);
                    }
                };
            }
        };
        int depth = new Solution().minDepth(root);
        System.out.println("depth: " + depth);
    }

    public int minDepth(TreeNode root) {
        if (root == null) return 0;

        int depth = Integer.MAX_VALUE;
        Deque<Pair> stack = new ArrayDeque<>();
        stack.push(new Pair(root, 1));

        while (!stack.isEmpty()) {
            Pair pair = stack.pop();
            if (pair.node.left == null && pair.node.right == null) {
                depth = Math.min(depth, pair.depth);
            }
            if (pair.node.left != null) {
                stack.push(new Pair(pair.node.left, pair.depth + 1));
            }
            if (pair.node.right != null) {
                stack.push(new Pair(pair.node.right, pair.depth + 1));
            }
        }

        return depth;
    }

    static class Pair {
        final TreeNode node;
        final int depth;

        Pair(TreeNode node, int depth) {
            this.node = node;
            this.depth = depth;
        }
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
