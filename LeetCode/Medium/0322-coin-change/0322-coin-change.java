/**
dp[i]: 주어진 배열 coins 원소 조합으로 i를 만들 수 있는 최솟값
불가능? dp[i] = 0
미결정? dp[i] = INF (integer overflow 될 수 있으니 Integer.MAX_VALUE 대신 amount + 1)
for (int coin : coins) {
    dp[i] = min(dp[i], dp[i - coin] + 1)
}
 */
import java.util.*;

class Solution {
    public int coinChange(int[] coins, int amount) {
        final int INF = amount + 1;

        int[] dp = new int[amount + 1];
        Arrays.fill(dp, INF);
        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (coin > i) continue;

                dp[i] = Math.min(
                    dp[i],
                    dp[i - coin] + 1
                );
            }
        }

        return dp[amount] == INF ? -1 : dp[amount];
    }
}