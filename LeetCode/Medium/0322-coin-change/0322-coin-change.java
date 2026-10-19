/**
1. State Definition
dp[i]: amount i를 만들 수 있는 조합 최솟값

2. Transition
dp[i]는 coins 배열 원소에 대해 순회했을 때 dp[i - coins[j]] + 1의 최솟값이다.

3. Base Case
dp[0] = 0
 */
class Solution {
    public int coinChange(int[] coins, int amount) {
        int INF = amount + 1;
        int[] dp = new int[amount + 1]; // 1-indexed
        Arrays.fill(dp, INF);

        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            int min = INF;
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] > i) {
                    continue;
                }

                int index = i - coins[j];
                if (dp[index] < INF) {
                    int temp = dp[index] + 1;
                    if (min > temp) {
                        min = temp;
                    }
                }
            }
            dp[i] = min;
        }

        return dp[amount] == INF ? -1 : dp[amount];
    }

}