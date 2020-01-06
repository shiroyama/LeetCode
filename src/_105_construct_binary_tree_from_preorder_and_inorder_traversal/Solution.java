package _105_construct_binary_tree_from_preorder_and_inorder_traversal;

import shared.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        TreeNode treeNode = new Solution().buildTree(preorder, inorder);
        System.out.println(treeNode);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) return null;
        if (inorder == null || inorder.length == 0) return null;

        Map<Integer, Integer> cache = new HashMap<>(inorder.length);
        for (int i = 0; i < inorder.length; i++) {
            cache.put(inorder[i], i);
        }

        return findRoot(preorder, 0, 0, preorder.length - 1, cache);
    }

    TreeNode findRoot(int[] preorder, int preStart, int inStart, int inEnd, Map<Integer, Integer> cache) {
        if (inStart > inEnd) return null;

        int rootVal = preorder[preStart];
        TreeNode root = new TreeNode(rootVal);

        int newInEnd = cache.get(rootVal);
        int diff = newInEnd - inStart;
        root.left = findRoot(preorder, preStart + 1, inStart, newInEnd - 1, cache);
        root.right = findRoot(preorder, preStart + diff + 1, newInEnd + 1, inEnd, cache);

        return root;
    }
}
