/**
각 원소마다 오른쪽 방향으로 반복적으로 scan한다면? O(N^2)
Monotonic Stack을 사용하면? O(N)
 */
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> stack = new ArrayDeque<>();
        int[] answer = new int[temperatures.length];

        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                int popped = stack.pop();
                answer[popped] = i - popped;
            }

            stack.push(i);
        }

        return answer;
    }
}