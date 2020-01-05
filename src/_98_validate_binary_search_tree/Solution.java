package _98_validate_binary_search_tree;

import shared.TreeNode;

import static shared.Utils.makeTree;

public class Solution {
    public static void main(String[] args) {
        TreeNode root = makeTree(new Integer[]{5, 1, 4, null, null, 3, 6});
        boolean validBST = new Solution().isValidBST(root);
        System.out.println(validBST);
    }

    public boolean isValidBST(TreeNode root) {
        return isValid(root, null, null);
    }

    boolean isValid(TreeNode node, Integer lower, Integer upper) {
        if (node == null) return true;
        if (lower != null && node.val <= lower) return false;
        if (upper != null && node.val >= upper) return false;
        return isValid(node.left, lower, node.val) && isValid(node.right, node.val, upper);
    }
}
