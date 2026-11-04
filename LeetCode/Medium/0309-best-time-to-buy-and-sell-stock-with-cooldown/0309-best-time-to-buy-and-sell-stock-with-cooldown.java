/**
State Machine DP
- Do I need multiple distinct states?
- Does the current state restrict what I can do next?

State Definition
- i번째 날 아래와 같은 선택을 했을 때의 이익 최댓값
- hold[i] : 보유
- sold[i] : 매도
- rest[i] : 보유 X, 매도 X

Transition
- hold[i] = max{hold[i - 1], rest[i - 1] - prices[i - 1]}
- sold[i] = hold[i - 1] + prices[i]
- rest[i] = max{sold[i - 1], rest[i - 1]}

Base Case
- hold[0] = -prices[0]
- sold[0] = Integer.MIN_VALUE
- rest[0] = 0
 */
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;

        int[] hold = new int[n];
        int[] sold = new int[n];
        int[] rest = new int[n];

        hold[0] = -prices[0];
        sold[0] = Integer.MIN_VALUE;
        rest[0] = 0;

        for (int i = 1; i < n; i++) {
            hold[i] = Math.max(hold[i - 1], rest[i - 1] - prices[i]);
            sold[i] = hold[i - 1] + prices[i];
            rest[i] = Math.max(rest[i - 1], sold[i - 1]);
        }

        return Math.max(sold[n - 1], rest[n - 1]);
    }
}