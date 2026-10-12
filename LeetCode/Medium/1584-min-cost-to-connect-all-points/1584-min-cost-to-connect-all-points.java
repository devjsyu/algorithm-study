import java.util.*;

class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;

        if (n == 0) {
            return 0;
        }

        // 간선 거리 정보 담긴 인접 행렬 초기화
        int[][] graph = new int[n][n];
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int distance = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]); 
                graph[i][j] = distance;
                graph[j][i] = distance;
            }
        }

        // MST에 연결되지 않은 정점의 최소 연결 비용
        int[] minDist = new int[n];
        Arrays.fill(minDist, Integer.MAX_VALUE);

        // MST 연결 여부
        boolean[] visited = new boolean[n];

        // 임의의 시작 정점
        minDist[0] = 0;

        // MST 총 비용
        int totalWeight = 0;

        for (int i = 0; i < n; i++) {
            int u = -1;
            // 최소 연결 비용을 찾기 위해 N번 순회
            for (int v = 0; v < n; v++) {
                if (visited[v]) {
                    continue;
                }

                if (u == -1 || minDist[v] < minDist[u]) {
                    u = v;
                }
            }

            // 연결되지 않은 그래프일 경우 필터링
            if (u == -1 || minDist[u] == Integer.MAX_VALUE) {
                return -1;
            }

            // MST 갱신
            totalWeight += minDist[u];
            visited[u] = true;

            // 새로 MST에 연결된 정점으로부터 연결된 정점에 대해 minDist 갱신
            for (int v = 0; v < n; v++) {
                if (visited[v]) {
                    continue;
                }

                if (graph[u][v] < minDist[v]) {
                    minDist[v] = graph[u][v];
                }
            }
        }

        return totalWeight;
    }
}