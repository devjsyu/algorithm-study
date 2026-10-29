/**
Pattern: Greedy / Running Minimum

Key Insight:
- 현재 날짜에 매도한다면, 이전 최저가에 매수하는 것이 최적이다.
- 따라서 과거 모든 가격을 저장할 필요가 없다.

Algorithm:
- 각 날짜마다 최저 가격과 최대 이익을 갱신한다.

Time Complexity: O(N)
Space Complexity: O(1)
 */
class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = prices[0];
        int maxProfit = 0;

        for (int price : prices) {
            minPrice = Math.min(minPrice, price);
            maxProfit = Math.max(maxProfit, price - minPrice);
        }

        return maxProfit;
    }
}