class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        Deque<Log> stack = new ArrayDeque<>();
        int[] exclusiveTime = new int[n];

        for (String logString : logs) {
            String[] parts = logString.split(":");
            Log log = new Log(Integer.parseInt(parts[0]), parts[1].equals("start"), Integer.parseInt(parts[2]));

            if (log.isStart()) {
                stack.push(log);
            } else {
                Log popped = stack.pop();
                int duration = log.timestamp() - popped.timestamp() + 1;
                exclusiveTime[popped.id()] += duration;

                if (!stack.isEmpty()) {
                    exclusiveTime[stack.peek().id()] -= duration;
                }
            }
        }

        return exclusiveTime;
    }

    public record Log(int id, boolean isStart, int timestamp) {}
}