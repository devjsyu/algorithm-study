/**
start? -> push to the stack
end? -> pop the stack and calculate the exclusive time
     -> exclusiveTimeForId[popped.id] += exclusiveTime
stack.isEmpty? -> no more function in the call stack
!stack.isEmpty? -> there's still at least one function running
                -> subtract the time for the single CPU
                -> exclusiveTimeForId[top.id] -= exclusiveTime
 */
class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] arr = new int[n];
        Deque<Log> stack = new ArrayDeque<>();
        
        for (String log : logs) {
            String[] parts = log.split(":");
            int id = Integer.parseInt(parts[0]);
            String status = parts[1];
            int timestamp = Integer.parseInt(parts[2]);

            if (status.equals("start")) {
                stack.push(new Log(id, status, timestamp));
            } else {
                Log popped = stack.pop();
                int exclusiveTime = timestamp - popped.timestamp() + 1;
                arr[id] += exclusiveTime;

                if (!stack.isEmpty()) {
                    arr[stack.peek().id()] -= exclusiveTime;
                }
            }
        }

        return arr;
    }

    public record Log(int id, String status, int timestamp) {}
}