package _33_search_in_rotated_sorted_array;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums1 = {1, 2, 3, 4, 5};
        int target1 = 2;
        int pos1 = solution.search(nums1, target1);
        assert pos1 == 1;

        int[] nums2 = {4, 5, 1, 2, 3};
        int target2 = 5;
        int pos2 = solution.search(nums2, target2);
        assert pos2 == 1;

        int[] nums3 = {5, 1, 2, 3, 4};
        int target3 = 1;
        int pos3 = solution.search(nums3, target3);
        assert pos3 == 1;
    }

    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] == target) return mid;

            // e.g. nums = [1, 2, 3, 4, 5], target = 2
            if (nums[0] < nums[mid] && target >= nums[0] && target < nums[mid]) {
                end = mid - 1;
                // e.g. nums = [4, 5, 1, 2, 3], target = 5
            } else if (nums[0] > nums[mid] && target >= nums[0]) {
                end = mid - 1;
                // e.g. nums = [5, 1, 2, 3, 4 ], target = 1
            } else if (nums[0] > nums[mid] && target < nums[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }
}
