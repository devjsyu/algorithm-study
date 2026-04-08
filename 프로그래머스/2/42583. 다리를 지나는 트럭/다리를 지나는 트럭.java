import java.util.ArrayDeque;
import java.util.Queue;

class Solution {
    public static void main(String[] args) {
        int bridge_length = 2;
        int weight = 10;
        int[] truck_weights = {7,4,5,6};
        int solution = solution(bridge_length, weight, truck_weights);
        System.out.println(solution);
    }
    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> bridge = new ArrayDeque<>();
        int totalWeight = 0;
        int seconds = 0;

        for (int i = 0; i < truck_weights.length; i++) {
            while (totalWeight + truck_weights[i] > weight) {
                if (bridge.size() >= bridge_length) {
                    int truckGone = bridge.poll();
                    totalWeight -= truckGone;
                } else {
                    bridge.add(0);
                    seconds++;
                }
            }
            bridge.add(truck_weights[i]);
            totalWeight += truck_weights[i];
            seconds++;
        }

        seconds += bridge_length;
        
        return seconds;
    }
}