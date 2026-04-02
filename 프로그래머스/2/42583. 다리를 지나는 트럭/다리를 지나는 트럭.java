import java.util.ArrayDeque;
import java.util.Queue;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> bridge = new ArrayDeque<>();
        int totalWeight = 0;
        int timeSpent = 0;
        for (int i = 0; i < truck_weights.length; i++) {
            while (true) {
                if (!bridge.isEmpty() && bridge.size() == bridge_length) {
                    int currentWeight = bridge.poll();
                    totalWeight -= currentWeight;
                } else {
                    if (weight - totalWeight >= truck_weights[i]) {
                        int currentWeight = truck_weights[i];
                        bridge.add(currentWeight);
                        totalWeight += currentWeight;
                        timeSpent++;
                        break;
                    } else {
                        bridge.add(0);
                        timeSpent++;
                    }
                }
            }
        }
        return timeSpent + bridge_length;
    }
}