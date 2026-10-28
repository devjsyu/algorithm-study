/**
1번 풀이: 문자 그대로 Queue와 Stack을 그대로 구현하기
 */
import java.util.*;

class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        int n = sandwiches.length;
        
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = n - 1; i >= 0; i--) {
            stack.push(sandwiches[i]);
        }

        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            queue.offer(students[i]);
        }

        int rejected = 0;
        while (!queue.isEmpty()) {
            if (stack.peek() == queue.peek()) {
                stack.pop();
                queue.poll();
                rejected = 0;
            } else {
                int refused = queue.poll();
                queue.offer(refused);
                rejected++;

                if (rejected == queue.size()) {
                    return rejected;
                }
            }
        }

        return 0;
    }
}