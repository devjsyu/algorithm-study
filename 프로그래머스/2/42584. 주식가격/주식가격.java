import java.util.Stack;

class Solution {
    public int[] solution(int[] prices) {
        Stack<Integer> stack = new Stack<>();
        boolean[] indexFallen = new boolean[prices.length];
        int[] answer = new int[prices.length];
        stack.push(prices[0]);
        for (int i = 1; i < prices.length; i++) {
            if (stack.peek() > prices[i]) {
                indexFallen[i] = true;
            }
            stack.push(prices[i]);
        }

        for (int i = 0; i < prices.length; i++) {
            answer[i] = prices.length - i - 1;
            for (int j = i + 1; j < prices.length; j++) {
                if (indexFallen[j] && prices[i] > prices[j]) {
                    answer[i] = j - i;
                    break;
                }
            }
        }

        return answer;
    }
}