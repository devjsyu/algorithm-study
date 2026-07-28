import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int[] solution(int[] prices) {
        // 자료구조 초기화
        Deque<Integer> indexPricesNeverDecreased = new ArrayDeque<>();
        indexPricesNeverDecreased.push(0);

        int[] answer = new int[prices.length];

        // prices 배열 순회하면서 이전 가격과 비교
        for (int i = 1; i < prices.length; i++) {
            // 가격 하락 한 경우
            while (!indexPricesNeverDecreased.isEmpty() && prices[indexPricesNeverDecreased.peek()] > prices[i]) {
                int indexPriceDecreased = indexPricesNeverDecreased.pop();
                answer[indexPriceDecreased] = i - indexPriceDecreased; // 기간 계산
            }

            // 가격 하락 이외 경우
            indexPricesNeverDecreased.push(i);
        }

        // 가격 하락하지 않았던 원소에 대해 순회하며 기간 계산
        for (Integer i : indexPricesNeverDecreased) {
            answer[i] = prices.length - i - 1;
        }

        return answer;
    }
}