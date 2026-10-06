import java.util.*;

class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;

        boolean[] visited = new boolean[n];
        int[] minDist = new int[n];
        Arrays.fill(minDist, Integer.MAX_VALUE);

        minDist[0] = 0;

        int totalCost = 0;

        for (int count = 0; count < n; count++) {
            // Find the unvisited point with the minimum connection cost
            int current = -1;

            for (int i = 0; i < n; i++) {
                if (!visited[i] &&
                    (current == -1 || minDist[i] < minDist[current])) {
                    current = i;
                }
            }

            // Add it to the MST
            visited[current] = true;
            totalCost += minDist[current];

            // Update connection costs
            for (int next = 0; next < n; next++) {
                if (!visited[next]) {
                    int distance = Math.abs(points[current][0] - points[next][0]) + Math.abs(points[current][1] - points[next][1]);

                    minDist[next] = Math.min(minDist[next], distance);
                }
            }
        }

        return totalCost;
    }
}