class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] answer = new int[n];
        Deque<Log> stack = new ArrayDeque<>();
        for (String log : logs) {
            String[] parts = log.split(":");
            int id = Integer.parseInt(parts[0]);
            boolean isStart = parts[1].equals("start");
            int timestamp = Integer.parseInt(parts[2]);

            if (isStart) {
                stack.push(new Log(id, isStart, timestamp));
            } else {
                Log popped = stack.pop();
                int currentExclusiveTime = timestamp - popped.timestamp() + 1;
                answer[popped.id()] += currentExclusiveTime;

                if (!stack.isEmpty()) {
                    Log peeked = stack.peek();
                    answer[peeked.id()] -= currentExclusiveTime;
                }
            }
        }

        return answer;
    }

    public record Log(int id, boolean isStart, int timestamp) {}
}