/**
최초 가격 하락 시점 탐색을 위해 monotonic stack 사용
is price decreased? 
    yes:   
        things that's not determined yet -> push to the stack
    no:
        while: the current thing is finally determined -> pop the stack
 */
class Solution {
    public int[] finalPrices(int[] prices) {
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < prices.length; i++) {
            while (!stack.isEmpty() && prices[stack.peek()] >= prices[i]) {
                int popped = stack.pop();
                prices[popped] = prices[popped] - prices[i];
            }

            stack.push(i);
        }

        return prices;
    }
}