package _112_path_sum;

import shared.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5) {
            {
                left = new TreeNode(4) {
                    {
                        left = new TreeNode(11) {
                            {
                                left = new TreeNode(7);
                                right = new TreeNode(2);
                            }
                        };
                    }
                };
                right = new TreeNode(8) {
                    {
                        left = new TreeNode(13);
                        right = new TreeNode(4) {
                            {
                                right = new TreeNode(1);
                            }
                        };
                    }
                };
            }
        };
        int sum = 22;
        boolean hasSum = new Solution().hasPathSum(root, sum);
        System.out.println("hasSum: " + hasSum);
    }

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        Deque<NodeWithSum> stack = new ArrayDeque<>();
        stack.push(new NodeWithSum(root, 0));
        while (!stack.isEmpty()) {
            NodeWithSum node = stack.pop();
            int tempSum = node.node.val + node.sum;
            if (node.node.left == null && node.node.right == null && tempSum == sum) return true;
            if (node.node.left != null) stack.push(new NodeWithSum(node.node.left, tempSum));
            if (node.node.right != null) stack.push(new NodeWithSum(node.node.right, tempSum));
        }
        return false;
    }

    static class NodeWithSum {
        final TreeNode node;
        final int sum;

        NodeWithSum(TreeNode node, int sum) {
            this.node = node;
            this.sum = sum;
        }
    }
}
