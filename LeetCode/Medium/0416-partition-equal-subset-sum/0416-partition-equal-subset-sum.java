/**
X(i, t) = OR{X(i - 1, t), X(i - 1, t - nums[i])}
 */
class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;

        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        if (sum % 2 != 0) {
            return false;
        }

        int target = sum / 2;

        boolean[][] dp = new boolean[n + 1][target + 1];
        dp[n][0] = true;

        for (int i = n - 1; i >= 0; i--) {
            for (int t = 0; t <= target; t++) {
                dp[i][t] = dp[i + 1][t];
                
                if (t - nums[i] >= 0) {
                    dp[i][t] = dp[i + 1][t] || dp[i + 1][t - nums[i]];
                }
            }
        }

        return dp[0][target];
    }
}