package _617_merge_two_binary_trees;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    public static void main(String[] args) {

    }

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return null;

        TreeNode result = new TreeNode(0);
        Deque<Triple> stack = new ArrayDeque<>();
        stack.push(new Triple(t1, t2, result));
        while (!stack.isEmpty()) {
            Triple triple = stack.pop();
            int leftVal = triple.left == null ? 0 : triple.left.val;
            int rightVal = triple.right == null ? 0 : triple.right.val;
            triple.result.val = leftVal + rightVal;

            TreeNode leftLeft = (triple.left != null && triple.left.left != null) ? triple.left.left : null;
            TreeNode rightLeft = (triple.right != null && triple.right.left != null) ? triple.right.left : null;
            if (leftLeft != null || rightLeft != null) {
                triple.result.left = new TreeNode(0);
                stack.push(new Triple(leftLeft, rightLeft, triple.result.left));
            }

            TreeNode leftRight = (triple.left != null && triple.left.right != null) ? triple.left.right : null;
            TreeNode rightRight = (triple.right != null && triple.right.right != null) ? triple.right.right : null;
            if (leftRight != null || rightRight != null) {
                triple.result.right = new TreeNode(0);
                stack.push(new Triple(leftRight, rightRight, triple.result.right));
            }
        }
        return result;
    }

    class Triple {
        final TreeNode left;
        final TreeNode right;
        final TreeNode result;

        Triple(TreeNode left, TreeNode right, TreeNode result) {
            this.left = left;
            this.right = right;
            this.result = result;
        }
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
