/**
dp[i]: 주어진 배열 coins 원소 조합으로 i를 만들 수 있는 최솟값
불가능? dp[i] = 0
미결정? dp[i] = INF
for (int coin : coins) {
    dp[i] = min(dp[i], dp[i - coin] + 1)
}
 */
import java.util.*;

class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        
        int[] dp = new int[amount + 1];

        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i - coin >= 0 && dp[i -coin] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}