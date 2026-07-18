import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int[] solution(int[] prices) {
        Deque<Integer> stack = new ArrayDeque<>();
        int[] answer = new int[prices.length];

        // 가격 배열 순회
        for (int i = 0; i < prices.length; i++) {
            // 가격 하락했을 경우
            while (!stack.isEmpty() && prices[stack.peek()] > prices[i]) {
                // 가격 하락한 시점 가격 인덱스
                int priceDecreased = stack.pop();
                // 정답 배열의 해당 인덱스에 가격 유지 기간 계산값 할당
                answer[priceDecreased] = i - priceDecreased;
            }

            // 가격 하락 이외 경우
            stack.push(i);
        }

        // Stack에 남아있는 인덱스는 단 한번도 가격 하락하지 않은 경우
        // 순회하면서 가격 유지 기간 계산
        for (Integer i : stack) {
            answer[i] = prices.length - 1 - i;
        }

        return answer;
    }
}