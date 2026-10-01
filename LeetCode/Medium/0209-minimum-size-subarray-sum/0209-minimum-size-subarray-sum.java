// Variable sized Sliding Window
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int sum = 0;
        int minLength = nums.length + 1;

        for (int right = 0; right < nums.length; right++) {
            // Expand the window by moving the right pointer
            sum += nums[right];

            while (sum >= target) {
                // Update the answer
                minLength = Math.min(minLength, right - left + 1);

                // Shrink the window by moving the left pointer
                sum -= nums[left];
                left++;
            }
        }

        return minLength <= nums.length ? minLength : 0;
    }
}