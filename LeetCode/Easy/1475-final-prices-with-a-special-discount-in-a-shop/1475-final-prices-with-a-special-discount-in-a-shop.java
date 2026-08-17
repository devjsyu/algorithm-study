class Solution {
    public int[] finalPrices(int[] prices) {
        // 직전 요소와 비교한다는 점에서 Stack 착안
        // Stack에 아직 결정되지 않은 요소의 index만 넣기
        // 조건이 만족할 경우(이후 나오는 요소의 가격이 더 작을 경우) 
        // 해당 요소는 결정되었으니 stack으로부터 pop
        // 해당 요소의 index에 대해 정답배열 원소 결정
        // 해당 요소의 pop 이후 이전 요소가 top이 되고 또 다시 조사하는 요소와 비교
        // 조건이 만족하지 않을 때까지 pop 반복하면서 정답배열 원소 결정
        // 조건이 더 이상 만족하지 않으면 조사하는 요소를 stack에 push
        // 배열 모두 순회했는데도 아직 stack에 남아있는 요소는 모두 조건 미충족

        // Stack 자료 구조 초기화
        Deque<Integer> stack = new ArrayDeque<>();

        // 주어진 배열 순회
        for (int i = 0; i < prices.length; i++) {
            // 조건 만족하는 경우
            while (!stack.isEmpty() && prices[stack.peek()] >= prices[i]) {
                // 정답 배열의 해당 인덱스의 원소 값 결정
                int popped = stack.pop();
                prices[popped] = prices[popped] - prices[i];
            }
 
            stack.push(i);
        }

        return prices;
    }
}