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
            for (int j = 0; j <= target; j++) {
                dp[i][j] = dp[i + 1][j];

                if (j - nums[i] >= 0) {
                    dp[i][j] = dp[i + 1][j] || dp[i + 1][j - nums[i]];
                }
            }
        }

        return dp[0][target];
    }
}