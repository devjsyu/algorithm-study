import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        Queue<String> queue1 = new ArrayDeque<>(Arrays.asList(cards1));
        Queue<String> queue2 = new ArrayDeque<>(Arrays.asList(cards2));
        for (int i = 0; i < goal.length; i++) {
            String word = goal[i];
            if (!queue1.isEmpty() && word.equals(queue1.peek())) {
                queue1.poll();
            } else if (!queue2.isEmpty() && word.equals(queue2.peek())) {
                queue2.poll();
            } else {
                return "No";
            }
        }
        return "Yes";
    }
}