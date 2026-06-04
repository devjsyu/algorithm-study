import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int weightsOnBridge = 0;
        int truckCount = truck_weights.length;
        int timePassed = 0;

        Deque<Integer> bridgeQueue = new ArrayDeque<>();
        for (int i = 0; i < bridge_length; i++) {
            bridgeQueue.offer(0);
        }

        Deque<Integer> waitingQueue = new ArrayDeque<>();
        for (int i = 0; i < truck_weights.length; i++) {
            waitingQueue.offer(truck_weights[i]);
        }

        List<Integer> trucksPassed = new ArrayList<>();

        while (trucksPassed.size() != truckCount) {
            // dequeue
            int passed = bridgeQueue.poll();
            if (passed != 0) {
                trucksPassed.add(passed);
                weightsOnBridge -= passed;
            }

            // enqueue
            if (!waitingQueue.isEmpty() && weight >= weightsOnBridge + waitingQueue.peek()) {
                int poll = waitingQueue.poll();
                bridgeQueue.offer(poll);
                weightsOnBridge += poll;
            } else {
                bridgeQueue.offer(0);
            }

            timePassed++;
        }

        return timePassed;
    }
}