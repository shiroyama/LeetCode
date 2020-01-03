package _108_convert_sorted_array_to_binary_search_tree;

public class Solution {
    public static void main(String[] args) {

    }

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        return makeBST(nums, 0, nums.length - 1);
    }

    TreeNode makeBST(int[] nums, int start, int end) {
        if (start > end) return null;

        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = makeBST(nums, start, mid - 1);
        root.right = makeBST(nums, mid + 1, end);
        return root;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
