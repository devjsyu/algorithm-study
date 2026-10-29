import java.util.*;

class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;

        int[] hold = new int[n];
        int[] sold = new int[n];
        int[] rest = new int[n];

        // Base Case
        hold[0] = -prices[0];
        sold[0] = Integer.MIN_VALUE;
        rest[0] = 0;

        // Topological Order
        for (int i = 1; i < n; i++) {
            // 주식을 계속 보유하거나 오늘 매수
            hold[i] = Math.max(hold[i - 1], rest[i - 1] - prices[i]);

            // 오늘 주식 매도
            sold[i] = hold[i - 1] + prices[i];

            // 계속 쉬거나 매도 다음 날 휴식
            rest[i] = Math.max(rest[i - 1], sold[i - 1]);
        }

        // 마지막 날에는 주식을 보유하지 않는 것이 최적
        return Math.max(sold[n - 1], rest[n - 1]);
    }
}