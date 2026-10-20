import java.util.*;

class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;

        if (n < 2) {
            return 1;
        }

        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        int lengthOfLIS = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            if (lengthOfLIS < dp[i]) {
                lengthOfLIS = dp[i];
            }
        }

        return lengthOfLIS;
    }
}