package _153_find_minimum_in_rotated_sorted_array;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int min = new Solution().findMin(nums);
        assert min == 0;
    }

    public int findMin(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            if (end - start == 1) return Math.min(nums[start], nums[end]);
            int mid = (start + end) / 2;
            if (nums[end] < nums[start] && nums[mid] > nums[end]) {
                start = mid;
            } else if (nums[end] < nums[start] && nums[mid] < nums[end]) {
                end = mid;
            } else {
                end = mid;
            }
        }
        return nums[start];
    }
}
