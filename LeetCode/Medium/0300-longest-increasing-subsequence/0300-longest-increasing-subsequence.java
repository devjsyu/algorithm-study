/**
SRTBOT

- Subproblems
    - nums[i:] (nums[i]로 시작하는 subsequence)
    - input subset in suffix

- Relate
    - dp[i] = 1 + max{dp[j] | i < j <= n, nums[i] < nums[j]}

- Topological Order
    - for |nums|, ..., 0

- Original Problem
    - max{dp[i] | 0 <= i <= |nums|}

- Time Complexity
    - O(N^2)
 */
import java.util.*;

class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n + 1]; // 1-indexed
        Arrays.fill(dp, 1);
        dp[n] = 0; // base case

        int maxLength = 1;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] < nums[j]) {
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                }
            }
            if (dp[i] > maxLength) {
                maxLength = dp[i];
            }
        }

        return maxLength;
    }
}