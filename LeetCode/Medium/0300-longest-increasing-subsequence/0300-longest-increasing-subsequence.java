/**
input: single sequence => input subset: suffix
Subproblem: dp[i] = index i로 시작하는 LIS의 길이
Relate: dp[i]는 1 + dp[j]의 최댓값. 이때, i < j <= n
Topological Order: for n, ..., 0
Original Problem: max{dp[i] | 0 <= i < n}
Time Complexity: O(N^2) 
 */
import java.util.*;

class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, 1);
        dp[n] = 0;

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] < nums[j]) {
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                }
            }
        }

        int maxLength = 1;
        for (int val : dp) {
            if (val > maxLength) {
                maxLength = val;
            }
        }

        return maxLength;
    }
}