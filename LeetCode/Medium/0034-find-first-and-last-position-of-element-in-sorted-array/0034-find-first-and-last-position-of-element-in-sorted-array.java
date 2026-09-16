/**
Binary Search
Lower Bound / Upper Bound

Finding the leftmost true
Lower Bound: if (target >= nums[mid])
Upper Bound: if (target > nums[mid])
 */
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int lower = lowerBound(nums, target);

        if (lower == nums.length || nums[lower] != target) {
            return new int[]{-1, -1};
        }

        int upper = upperBound(nums, target);

        return new int[]{lower, upper - 1};
    }

    private int lowerBound(int[] nums, int target) {
        int left = 0;
        int right = nums.length;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (target <= nums[mid]) {
                right = mid;
            } else if (target > nums[mid]) {
                left = mid + 1;
            }
        }

        return left;
    }

    private int upperBound(int[] nums, int target) {
        int left = 0;
        int right = nums.length;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (target < nums[mid]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }
}