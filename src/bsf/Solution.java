package bsf;

import shared.TreeNode;
import shared.Utils;

import java.util.ArrayDeque;
import java.util.Deque;

import static shared.Utils.makeTree;

public class Solution {
    public static void main(String[] args) {
        TreeNode treeNode = makeTree(new Integer[]{3, 9, 20, 8, 53, null, null, null, null, 15, 7, null, null, null, null});
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.add(treeNode);
        while (!queue.isEmpty()) {
            TreeNode node = queue.remove();
            System.out.println("Node: " + node.val);
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
    }
}
