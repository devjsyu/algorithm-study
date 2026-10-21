/**
SRTBOT
- Subproblem
    - dp[i]: length i 길이의 `Good String` 조합 개수 % MOD

- Relate
    - dp[i] = sum{dp[i - zero] + dp[i - one]} % MOD

- Topological Order
    - for 0, ..., n

- Base Case
    - dp[0]: 1

- Original Problem
    - sum{dp[low, ..., high]}

- Time Complexity
    - O(N)
 */
class Solution {
    public int countGoodStrings(int low, int high, int zero, int one) {
        int[] dp = new int[high + 1];
        dp[0] = 1;

        for (int i = Math.min(zero, one); i < low; i++) {
            dp[i] = dp[i - Math.min(zero, one)] % MOD;
            if (i - Math.max(zero, one) >= 0) {
                dp[i] += dp[i - Math.max(zero, one)] % MOD;
            }
        }
        
        for (int i = low; i <= high; i++) {
            dp[i] = (dp[i] + dp[i - zero]) % MOD;
            dp[i] = (dp[i] + dp[i - one]) % MOD;
        } 
        
        int answer = 0;
        for (int i = low; i <= high; i++) {
            answer = (answer + dp[i]) % MOD;
        }

        return answer;
    }

    private static final int MOD = 1_000_000_007;
}