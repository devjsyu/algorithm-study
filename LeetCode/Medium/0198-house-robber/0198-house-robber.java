/**
1. State Definition
dp[i]: i번째 최댓값

2. Transition
dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1])

3. Base Case
dp[0] = nums[0]
dp[1] = Math.max(nums[0], nums[1])
 */
class Solution {
    public int rob(int[] nums) {
        int n = nums.length;

        if (n < 2) return nums[0];
        
        int[] dp = new int[n];

        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]);
        }

        return dp[n - 1];
    }
}