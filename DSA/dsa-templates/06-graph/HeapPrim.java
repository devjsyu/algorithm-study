import java.util.*;

public class HeapPrim {

    // 인접 리스트에서 사용하는 간선
    public record Edge(int to, int weight) {}

    // 우선순위 큐에서 사용하는 후보 상태
    public record State(int vertex, int cost) {}

    /**
     * Heap-based Prim's Algorithm
     *
     * 목적:
     * - 가중치가 있는 무방향 그래프의 MST 총 가중치를 구한다.
     *
     * 입력:
     * - graph[u]: 정점 u에서 출발하는 간선 목록
     * - 무방향 그래프이므로 양방향 간선 저장 필요
     *
     * 시간 복잡도: O(ElogV) (연결 그래프 기준)
     * 공간 복잡도: O(V + E)
     *
     * 반환:
     * - MST의 총 가중치
     * - 연결되지 않은 그래프라면 -1
     */
    public static long prim(List<Edge>[] graph) {
        int n = graph.length;

        if (n == 0) {
            return 0;
        }

        // visited[v]:
        // 정점 v가 MST에 포함되었는지 여부
        boolean[] visited = new boolean[n];

        // minDist[v]:
        // 현재 MST와 정점 v를 연결하는 최소 간선 비용
        int[] minDist = new int[n];
        Arrays.fill(minDist, Integer.MAX_VALUE);

        // cost가 가장 작은 후보부터 꺼낸다.
        PriorityQueue<State> pq = new PriorityQueue<>(
                Comparator.comparingInt(State::cost)
        );

        // 시작 정점 설정
        minDist[0] = 0;
        pq.offer(new State(0, 0));

        long totalWeight = 0;
        int mstVertices = 0;

        while (!pq.isEmpty()) {

            // STEP 1.
            // 현재 연결 후보 중 최소 비용을 꺼낸다.
            State current = pq.poll();

            int u = current.vertex();
            int cost = current.cost();

            // STEP 2.
            // 이미 MST에 포함된 정점이라면 무시한다.
            if (visited[u]) {
                continue;
            }

            // STEP 3.
            // 정점 u를 MST에 추가한다.
            visited[u] = true;
            mstVertices++;

            // u를 MST에 연결하는 간선 비용 추가
            totalWeight += cost;

            // 모든 정점이 MST에 포함되었다면 종료
            if (mstVertices == n) {
                break;
            }

            // STEP 4.
            // 새로 추가된 정점 u의 인접 간선을 확인한다.
            for (Edge edge : graph[u]) {
                int v = edge.to();
                int weight = edge.weight();

                // 이미 MST에 포함된 정점은 제외
                if (visited[v]) {
                    continue;
                }

                // STEP 5.
                // u-v 간선이 기존 최소 연결 비용보다 작으면 minDist 갱신한다.
                if (weight < minDist[v]) {
                    minDist[v] = weight;

                    // 갱신된 연결 비용을 힙에 추가한다.
                    // 기존 후보는 힙에 남아있을 수 있지만 나중에 visited[] 검사로 무시된다.
                    pq.offer(new State(v, weight));
                }
            }
        }

        // 모든 정점을 MST에 포함하지 못했다면 그래프는 연결되지 않은 상태다.
        if (mstVertices != n) {
            return -1;
        }

        /**
         * 무방향 가중치 그래프 초기화
         *
         * edges[i] = {u, v, weight}
         * 정점 번호: 0 ~ n - 1
         */
        @SuppressWarnings("unchecked")
        public static List<Edge>[] buildGraph(int n, int[][] edges) {
            List<Edge>[] graph = new ArrayList[n];

            for (int i = 0; i < n; i++) {
                graph[i] = new ArrayList<>();
            }

            for (int[] edge : edges) {
                int u = edge[0];
                int v = edge[1];
                int weight = edge[2];

                // 무방향 그래프이므로 양방향 추가
                graph[u].add(new Edge(v, weight));
                graph[v].add(new Edge(u, weight));
            }

            return graph;
        }
    }
}