/**
monotonic stack
각 원소에 대해 오른쪽에서 처음 만나는 더 큰 값
 */
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> monotonicStack = new ArrayDeque<>();
        int[] answer = new int[temperatures.length];

        for (int i = 0; i < temperatures.length; i++) {
            while (!monotonicStack.isEmpty() && temperatures[monotonicStack.peek()] < temperatures[i]) {
                int popped = monotonicStack.pop();
                answer[popped] = i - popped;
            }

            monotonicStack.push(i);
        }

        return answer;
    }
}