import java.util.ArrayDeque;
import java.util.ArrayList;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < progresses.length; i++) {
            queue.add((100 - progresses[i] + speeds[i] - 1) / speeds[i]);
        }
        ArrayList<Integer> list = new ArrayList<>();
        Integer bottleneck = queue.poll();
        int count = 1;
        while (!queue.isEmpty()) {
            Integer work = queue.poll();
            if (bottleneck != null && bottleneck < work) {
                bottleneck = work;
                list.add(count);
                count = 1;
            } else {
                count++;
            }
        }
        list.add(count);
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}