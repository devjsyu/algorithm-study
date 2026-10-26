/**
- Subproblem
    - X(i, t): nums[i:n] 범위 subset sum이 목표값 t를 만족하는지 여부

- Recurrence
    - X(i, t) = OR(X(i + 1, t), X(i + 1, t - nums[i]))

- Topological Order
    - for i : n, ..., 0 (단, t - nums[i] >= 0)
        - for t : 0, ..., T
        - 단, T는 짝수

- Base Case
    - X(n, 0) = true
    - X(n, t) = false, 0 < t <= T

- Original Problem
    - X(0, T)

- Time Complexity
    - O(N * T)
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
                // nums[i]를 선택하지 않음
                dp[i][t] = dp[i + 1][t];

                // nums[i]를 선택함
                if (t - nums[i] >= 0) {
                    dp[i][t] = dp[i + 1][t] || dp[i + 1][t - nums[i]];
                }
            }
        }

        return dp[0][target];
    }
}