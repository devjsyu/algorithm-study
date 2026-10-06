import java.util.*;

/**
 * PriorityQueue-based Prim's Algorithm
 */
public class Prim {

    record Edge(int to, int weight) {}

    /**
     * Prim's Algorithm
     *
     * 목적:
     * - 연결된 무방향 가중치 그래프에서 MST의 총 가중치를 구한다.
     *
     * 핵심 아이디어:
     * 1. 임의의 정점 하나에서 시작한다.
     * 2. 현재 MST와 연결할 수 있는 간선 중 가장 가중치가 작은 간선을 선택한다.
     * 3. 아직 MST에 포함되지 않은 정점을 추가한다.
     * 4. 모든 정점이 포함될 때까지 반복한다.
     *
     * PriorityQueue에는 "현재 SMT에서 접근 간으한 후보 간선"을 저장한다.
     *
     * visited[v] == true
     * -> 정점 v는 이미 MST에 포함되어 있다.
     */
    static long prim(List<Edge>[] graph) {
        int n = graph.legnth;

        // 이미 MST에 포함된 정점인지 확인한다.
        boolean[] visited = new boolean[];

        /**
         * 최소 힙
         * -> Edge의 weight가 가장 작은 원소가 먼저 나온다.
         *
         * Edge.to: "새롭게 MST에 추가할 후보 정점"
         * Edge.weight: "그 정점을 연결하는 비용"
         */
        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(Edge::weight));

        pq.offer(new Edge(0, 0));

        long totalWeight = 0;
        int count = 0; // MST에 포함된 정점 수

        while (!pq.isEmpty()) {

            // 현재 선택 가능한 간선 중 가장 저렴한 간선
            Edge current = pq.poll();

            int node = current.to();
            int weight = current.weight();

            // 이미 MST에 포함된 정점이라면 무시
            if (visited[node]) {
                continue;
            }

            visited[node] = true;
            totalWeight += weight;
            count++;

            // 새롭게 MST에 들어온 node와 연결된 간선들을 다음 후보로서 PriorityQueue에 넣는다.
            for (Edge next : graph[node]) {

                // 이미 MST에 포함된 정점으로 가는 간선을 필요 없다.
                if (!visited[next.to()]) {
                    pq.offer(next);
                }
            }
        }

        // 모든 정점을 방문하지 못했다면 그래프가 disconnected라는 뜻이다.
        if (count != n) {
            return -1;
        }

        return totalWeight;
    }
}