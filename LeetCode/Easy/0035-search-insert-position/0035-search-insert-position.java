class Solution {
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int answer = 0;
        int middle = -1;

        while (left <= right) {
            middle = (left + right) / 2;

            if (target == nums[middle]) {
                return middle;
            } else if (target > nums[middle]) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }

        return target > nums[middle] ? middle + 1 : middle;
    }
}