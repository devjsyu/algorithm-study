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

        // dp[i][t]:
        // nums[i:]에서 합계 t를 만들 수 있는지 여부
        boolean[][] dp = new boolean[n + 1][target + 1];

        // Base Case
        dp[n][0] = true;

        // Topological Order
        for (int i = n - 1; i >= 0; i--) {
            for (int t = 0; t <= target; t++) {

                // nums[i]를 선택하지 않음
                dp[i][t] = dp[i + 1][t];

                // nums[i]를 선택함
                if (t - nums[i] >= 0) {
                    dp[i][t] = dp[i][t] || dp[i + 1][t - nums[i]];
                }
            }
        }

        return dp[0][target];
    }
}