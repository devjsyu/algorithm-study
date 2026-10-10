// Fixed-size Sliding Window
class Solution {
    public double findMaxAverage(int[] nums, int k) {
        // build the first window
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }

        int max = sum;

        // slide the window
        for (int i = k; i < nums.length; i++) {
            // incoming
            sum += nums[i];

            // outgoing
            sum -= nums[i - k];

            // update answer
            max = Math.max(max, sum);
        }

        return (double) max / k;
    }
}