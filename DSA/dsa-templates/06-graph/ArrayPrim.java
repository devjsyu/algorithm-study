import java.util.*;

public class ArrayPrim {

    private static final int INF = Integer.MAX_VALUE;

    /**
     * Array-based Prim's Algorithm
     *
     * 목적:
     * - 가중치가 있는 무방향 그래프의 MST 총 가중치를 구한다.
     *
     * 입력:
     * - graph[u][v]: 정점 u와 v를 연결하는 간선의 가중치
     * - 간선이 존재하지 않으면 INF
     * - graph[u][u] = 0
     * - 무방향 그래프이므로 graph[u][v] == graph[v][u]
     *
     * 시간 복잡도: O(V^2)
     * 공간 복잡도:
     * - 알고리즘 추가 공간: O(V)
     * - 인접 행렬 저장 공간: O(V^2)
     *
     * 반환:
     * - MST의 총 가중치
     * - 연결되지 않은 그래프라면 -1
     */
    public static long prim(int[][] graph) {
        int n = graph.length;

        if (n == 0) {
            return 0;
        }

        // visited[v]:
        // 정점 v가 MST에 포함되었는지 여부
        boolean[] visited = new boolean[n];

        // minDist[v]:
        // 현재 MST와 정점 v를 연결하는 간선 중 최소 가중치
        int[] minDist = new int[n];
        Arrays.fill(minDist, INF);

        // 시작 정점은 임의로 선택 가능
        // 0번 정점부터 시작하며, 선택 비용은 0
        minDist[0] = 0;

        long totalWeight = 0;

        // MST에 총 n개의 정점을 추가한다.
        for (int i = 0; i < n; i++) {

            // STEP 1.
            // 아직 MST에 포함되지 않은 정점 중 minDist가 가장 작은 정점을 찾는다.
            int u = -1;

            for (int v = 0; v < n; v++) {
                if (visited[v]) {
                    continue;
                }

                if (u == -1 || minDist[v] < minDist[u]) {
                    u = v;
                }
            }

            // STEP 2.
            // 선택 가능한 정점이 없거나
            // 남은 정점과 MST를 연결한 간선이 없다면
            // 그래프는 연결되지 않은 상태다.
            if (u == -1 || minDist[u] == INF) {
                return -1;
            }

            // STEP 3.
            // 정점 u를 MST에 추가한다.
            visited[u] = true;

            // u를 MST에 연결하는 최소 간선 비용 추가
            // 시작 정점의 비용은 0
            totalWeight += minDist[u];

            // STEP 4.
            // 새로 추가된 정점 u를 이용하여
            // 다른 정점들의 최소 연결 비용을 갱신한다.
            for (int v = 0; v < n; v++) {

                // 이미 MST에 포함된 정점은 제외
                if (visited[v]) {
                    continue;
                }

                // u-v 간선이 존재하고 기존 최소 연결 비용보다 작으면 갱신
                if (graph[u][v] < minDist[v]) {
                    minDist[v] = graph[u][v];
                }
            }
        }

        return totalWeight;
    }
}