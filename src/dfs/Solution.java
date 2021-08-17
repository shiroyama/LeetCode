package dfs;

import shared.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

import static shared.Utils.makeTree;

public class Solution {
    public static void main(String[] args) {
        TreeNode treeNode = makeTree(new Integer[]{3, 9, 20, 8, 53, null, null, null, null, 15, 7, null, null, null, null});
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(treeNode);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            System.out.println("Node: " + node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
    }
}
