/**
탐색 중인 인덱스 이후 최초의 하락 가격에 대해 차감한 만큼 할인 적용됨
 */
class Solution {
    public int[] finalPrices(int[] prices) {
        int[] answer = new int[prices.length];
        for (int i = 0; i < prices.length; i++) {
            answer[i] = prices[i];
        }

        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[i] >= prices[j]) {
                    answer[i] = prices[i] - prices[j];
                    break;
                }
            }
        }

        return answer;
    }
}