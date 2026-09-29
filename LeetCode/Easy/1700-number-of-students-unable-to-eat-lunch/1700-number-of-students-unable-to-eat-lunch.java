class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = sandwiches.length - 1; i >= 0; i--) {
            stack.push(sandwiches[i]);
        }

        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < students.length; i++) {
            queue.offer(students[i]);
        }

        while (!queue.isEmpty()) {
            // unable to eat case
            if (!stack.isEmpty() 
            && ((stack.peek() == 0 && !queue.contains(Integer.valueOf(0))) 
            || (stack.peek() == 1 && !queue.contains(Integer.valueOf(1))))) {
                return queue.size();
            }

            // matched case
            if (!stack.isEmpty() && stack.peek() == queue.peek()) {
                stack.pop();
                queue.poll();
            } 
    
            // mismatched case
            if (!stack.isEmpty() && stack.peek() != queue.peek()) {
                int mismatched = queue.poll();
                queue.offer(mismatched);
            } 
        }

        return 0;
    }
}