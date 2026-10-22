class Solution {
    public int change(int amount, int[] coins) {
        // dp[a]: 금액 a를 만드는 동전 조합의 개수
        int[] dp = new int[amount + 1];

        // 아무 동전도 사용하지 않는 한 가지 방법
        dp[0] = 1;

        // 동전 종류를 먼저 순회
        for (int coin : coins) {
            // 현재 동전을 사용하여 만들 수 있는 금액
            for (int a = coin; a <= amount; a++) {
                dp[a] += dp[a - coin];
            }
        }

        return dp[amount];
    }
}