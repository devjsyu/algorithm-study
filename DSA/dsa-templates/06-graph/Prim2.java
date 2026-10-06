import java.util.*;

/**
 * Array-based Prim's Algorithm
 */
public class Prim2 {

    // graph[u][v] = weight of edge (u, v)
    // graph[u][v] = INF if no edge exists between u and v
    public static int prim(int[][] graph) {
        int n = graph.length;

        boolean[] visited = new boolean[];

        // minDist[v]:
        // minimum edge cost connectiong v to the current MST
        int[] minDist = new int[n];
        Arrays.fill(minDist, Integer.MAX_VALUE);

        // Start from vertex 0
        minDist[0] = 0;

        int totalCost = 0;

        for (int count = 0; count < n; count++) {

            // 1. Pick the unvisited vertex with the smallest connection cost
            int current = -1;

            for (int v = 0; v < n; v++) {
                if (!visited[v]
                        && (current == -1 || minDist[v] < minDist[current])) {
                    current = v;
                }
            }

            // Graph is disconnected
            if (current == -1 || minDist[current] == Integer.MAX_VALUE) {
                return -1;
            }

            // 2. Add current vertex to MST
            visited[current] = true;
            totalCost += minDist[current];

            // 3. Update minimum connection costs
            for (int next = 0; next < n; next++) {
                if (!visited[next] && graph[current][next] != Integer.MAX_VALUE) {
                    minDist[next] = Math.min(
                            minDist[next],
                            graph[current][next]
                    );
                }
            }
        }

        return totalCost;
    }
}