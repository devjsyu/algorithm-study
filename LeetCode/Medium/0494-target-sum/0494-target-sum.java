/**
Subproblem
X(i, t): [i, n) 범위 subset sum이 t를 만족하는 경우의 수 개수

Recurrence
X(i, t) = sum{X(i + 1, t + nums[i]), X(i + 1, t - nums[i])}

Topological Order
for i : n - 1, ..., 0
for t : 0, ..., target

Base Case
X(n, 0) = 1

Original Problem
X(0, target)
 */
class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        if (Math.abs(target) > sum) {
            return 0;
        }

        int n = nums.length;
        int offset = sum;

        int[][] dp = new int[n + 1][2 * sum + 1];
        dp[n][offset] = 1;

        for (int i = n - 1; i >= 0; i--) {
            for (int t = -sum; t <= sum; t++) {
                int count = dp[i + 1][t + offset];

                if (count == 0) {
                    continue;
                }

                // 현재 숫자에 + 부호를 붙인다.
                if (t + nums[i] <= sum) {
                    dp[i][t + nums[i] + offset] += count;
                }

                // 현재 숫자에 - 부호를 붙인다.
                if (t - nums[i] >= -sum) {
                    dp[i][t - nums[i] + offset] += count;
                }
            }
        }

        return dp[0][target + offset];
    }
}