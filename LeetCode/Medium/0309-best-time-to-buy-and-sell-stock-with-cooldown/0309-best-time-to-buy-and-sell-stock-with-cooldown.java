/**
Subproblem
i번째날 ~~ 하는 선택을 했을 때의 이익 최댓값
hold[i] : 보유
rest[i] : 보유 X, 매도 X
sold[i] : 매도

Recurrence
hold[i] = max{hold[i - 1], rest[i - 1] - prices[i]}
rest[i] = max{hold[i - 1] + prices[i - 1], rest[i - 1]}
sold[i] = hold[i - 1] + prices[i]

Topological Order
for i : 0, ..., n

Base Case
hold[0] = -prices[0]
rest[0] = 0
sold[0] = -INF

Original Problem
max{sold[n - 1], rest[n - 1]}

Time Complexity
O(N)
 */
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;

        int[] hold = new int[n];
        int[] rest = new int[n];
        int[] sold = new int[n];

        hold[0] = -prices[0];
        rest[0] = 0;
        sold[0] = Integer.MIN_VALUE;

        for (int i = 1; i < n; i++) {
            hold[i] = Math.max(hold[i - 1], rest[i - 1] - prices[i]);
            rest[i] = Math.max(sold[i - 1], rest[i - 1]);
            sold[i] = hold[i - 1] + prices[i];
        }

        return Math.max(rest[n - 1], sold[n - 1]);
    }
}