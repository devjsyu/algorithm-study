/**
- Subproblem
    - X(i): nums 배열 [0, i] 범위의 money 최댓값

- Recurrence
    - X(i) = max{X(i - 2) + nums[i], X(i - 1)}

- Topological Order
    - for i : 0, ..., n

- Base Case
    - X(0) = 0
    - X(1) = nums[0]

- Original Problem
    - X(n)

- Time Complexity
    - O(N)
 */
class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = nums[0];

        for (int i = 2; i <= n; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i - 1], dp[i - 1]);
        }

        return dp[n];
    }
}