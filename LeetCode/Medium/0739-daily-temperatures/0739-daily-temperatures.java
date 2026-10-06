/**
Why monotonic stack?
각 배열 원소마다 오른쪽 방향 원소들을 탐색해야 하는 상황 (O(N^2)의 시간복잡도)
아직 결정되지 않은 원소를 스택에 넣고 새로운 원소에 대해 스택의 탑과 반복 비교한다면? 
각 원소는 스택에 대해 pop, push 과정을 최대 1번씩만 하면 되니까, O(N) 시간복잡도로 처리할 수 있게 된다!
 */
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> stack = new ArrayDeque<>();
        int[] days = new int[temperatures.length];

        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                int popped = stack.pop();
                days[popped] = i - popped;
            }
            stack.push(i);
        }

        // 스택에 남은 원소 처리
        while (!stack.isEmpty()) {
            days[stack.pop()] = 0;
        }

        return days;
    }
}