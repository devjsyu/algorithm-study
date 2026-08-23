import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        List<Integer> passed = new ArrayList<>();
        Queue<Integer> bridge = new ArrayDeque<>();
        int index = 0;
        int timePassed = 0;
        int remainderWeight = weight;
        while (passed.size() != truck_weights.length) {
            if (!bridge.isEmpty() && bridge.size() == bridge_length) {
                int polled = bridge.poll();
                if (polled > 0) {
                    passed.add(polled);
                    remainderWeight += polled;
                }
            }

            if (truck_weights.length > index && remainderWeight >= truck_weights[index]) {
                bridge.offer(truck_weights[index]);
                remainderWeight -= truck_weights[index];
                index++;
            } else {
                bridge.offer(0);
            }
            timePassed++;
        }

        return timePassed;
    }
}