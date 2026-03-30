import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < progresses.length; i++) {
            int job = 100 - progresses[i];
            int days = job % speeds[i] == 0 ? job / speeds[i] : job / speeds[i] + 1;
            queue.add(days);
        }

        ArrayList<Integer> list = new ArrayList<>();
        int count = 1;

        if (queue.isEmpty()) {
            return new int[]{0};
        }
        int limit = queue.poll();

        while (!queue.isEmpty()) {
            int poll = queue.poll();
            if (limit >= poll) {
                count++;
            } else {
                list.add(count);
                count = 1;
                limit = poll;
            }
        }
        list.add(count);
        
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}