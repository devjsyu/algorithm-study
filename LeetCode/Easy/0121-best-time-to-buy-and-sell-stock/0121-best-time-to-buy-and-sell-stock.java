/**
Naive Approach                  => O(N^2) => TLE
(Increasing) Monotonic Stack    => O(N)
 */
class Solution {
    public int maxProfit(int[] prices) {
        Deque<Integer> stack = new ArrayDeque<>();
        
        int n = prices.length;        
        int maxMargin = 0;

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && prices[stack.peek()] > prices[i]) {
                int popped = stack.pop();
                if (stack.isEmpty()) continue;
                int temp = prices[popped] - prices[stack.getLast()];
                maxMargin = Math.max(maxMargin, temp);
            }
            
            stack.push(i);
        }

        if (!stack.isEmpty()) {
            maxMargin = Math.max(maxMargin, prices[stack.getFirst()] - prices[stack.getLast()]);
        }

        return maxMargin;
    }
}