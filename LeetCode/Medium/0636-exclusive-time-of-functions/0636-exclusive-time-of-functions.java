class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] exclusiveTimeArray = new int[n];
        Deque<Log> stack = new ArrayDeque<>();
        
        for (String log : logs) {
            Log current = new Log(log);

            if (current.isStart) {
                stack.push(current);
            } else {
                Log popped = stack.pop();
                int duration = current.timestamp - popped.timestamp + 1;
                exclusiveTimeArray[popped.id] += duration;

                if (!stack.isEmpty()) {
                    exclusiveTimeArray[stack.peek().id] -= duration;
                }
            }
        }

        return exclusiveTimeArray;
    }

    public static class Log {
        private int id;
        private boolean isStart;
        private int timestamp;

        public Log(String log) {
            String[] parts = log.split(":");

            this.id = Integer.parseInt(parts[0]);
            this.isStart = parts[1].equals("start");
            this.timestamp = Integer.parseInt(parts[2]);
        }
    } 
}