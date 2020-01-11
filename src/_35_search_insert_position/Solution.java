package _35_search_insert_position;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};
        int target = 5;
        int i = new Solution().searchInsert(nums, target);
        assert i == 2;

        int[] nums2 = {1, 3, 5, 6};
        int target2 = 2;
        int i2 = new Solution().searchInsert(nums2, target2);
        assert i2 == 1;
    }

    public int searchInsert(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] == target) return mid;
            if (nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }
}
