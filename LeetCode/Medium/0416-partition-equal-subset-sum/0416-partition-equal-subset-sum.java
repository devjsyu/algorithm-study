/**
- Overlapping problems
- Optimal substructure

Pattern: 0/1 Knapsack (Decision Problem)

1. State Definition
dp[s]: 지금까지 처리한 숫자들로 합계 s를 만들 수 있는지 여부

2. Transition
dp[s] = dp[s] || dp[s - num]
- Not take: dp[s]
- Take:     dp[s - num]

3. Base Case
dp[0] = true
 */
class Solution {
    public boolean canPartition(int[] nums) {
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        if (totalSum % 2 != 0) {
            return false;
        }

        int target = totalSum / 2;

        // dp[s]: 합계 s를 만들 수 있는지 여부
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;

        for (int num : nums) {
            for (int s = target; s >= num; s--) {
                dp[s] = dp[s] || dp[s - num];
            }
        }

        return dp[target];
    }
}