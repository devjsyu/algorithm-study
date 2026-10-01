class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int sum = 0;
        int length = 0;
        int minLength = nums.length + 1;

        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            length++;

            if (sum >= target) {
                minLength = Math.min(minLength, length);
            }

            while (left < right && sum - nums[left] >= target) {
                sum -= nums[left];
                length--;
                left++;

                minLength = Math.min(minLength, length);
            }
        }

        return minLength <= nums.length ? minLength : 0;
    }
}