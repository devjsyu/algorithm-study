import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Deque<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < progresses.length; i++) {
            int remainingDays = (100 - progresses[i] + speeds[i] - 1) / speeds[i]; // 나눗셈의 몫을 무조건 올림
            queue.offer(remainingDays);
        }

        List<Integer> list = new ArrayList<>();
        int count = 0;
        int maxRemainingDays = (100 - progresses[0] + speeds[0] - 1) / speeds[0]; // 첫 번째 요소

        while (!queue.isEmpty()) {
            int peek = queue.peek();
            if (maxRemainingDays < peek) {
                maxRemainingDays = peek;
                list.add(count);
                count = 0;
            } else {
                queue.poll();
                count++;
            }
        }
        list.add(count); // 마지막 요소 추가

        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}