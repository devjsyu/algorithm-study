class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        // Monotonic Stack
        // 아직 조건 충족 여부가 결정되지 않은 원소를 stack에 담아 대기한다
        // 대기하는 원소 중 가장 최신 원소와 조사 대상 원소를 비교한다
        // 조건을 만족하면 해당 대기 원소를 pop하고, 아니라면 조사 대상 원소를 push 한다
        // O(N^2) 탐색하는 대신, 각 원소는 최소 pop, push 1번만 연산만 하면 된다
        // 정답 배열의 원소는 기존 배열의 인덱스를 기반으로 계산해서 값을 결정한다

        // 정답 배열 초기화
        int[] answer = new int[temperatures.length];

        // Stack 자료구조 초기화
        Deque<Integer> elementsNotDeterminedYet = new ArrayDeque<>();

        // 주어진 배열 순회
        for (int i = 0; i < temperatures.length; i++) {
            // 조건 만족하는 경우 (대기 중인 원소 인덱스에 대한 온도보다 조사 대상 인덱스에 대한 온도가 더 높을 때) 
            while (!elementsNotDeterminedYet.isEmpty() && 
            temperatures[elementsNotDeterminedYet.peek()] < temperatures[i]) {
                int popped = elementsNotDeterminedYet.pop();
                answer[popped] = i - popped;
            }
            elementsNotDeterminedYet.push(i);
        }

        return answer;
    }
}