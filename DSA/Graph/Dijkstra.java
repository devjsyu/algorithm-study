import java.util.*;

/**
 * 1. 가장 유망한 거리 후보를 가져온다.
 * 2. 그런데 더 좋은 정보가 이미 발견됐는지 확인한다.
 * 3. 최신 정보라면 이 노드에서 갈 수 있는 곳을 확인한다.
 * 4. 이 노드를 거쳐 가면 거리가 얼마인지 계산한다.
 * 5. 기존에 알던 것보다 좋은가?
 * 6. 좋다면 최고 기록을 갱신한다.
 * 7. 이 새로운 기록을 기반으로 탐색해야 하므로 PQ에 넣는다.
 */
class Dijkstra {

    // 그래프의 간선
    static class Edge {
        int to;
        int weight;

        Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    // PriorityQueue에 저장할 상태
    static class State {
        int node;
        int dist;

        State(int node, int dist) {
            this.node = node;
            this.dist = dist;
        }
    }

    // Dijkstra 결과
    static class Result {
        int[] dist;
        int[] prev;

        Result(int[] dist, int[] prev) {
            this.dist = dist;
            this.prev = prev;
        }
    }

    static Result dijkstra(List<Edge>[] graph, int start) {
        int n = graph.length;

        // 최단거리 배열
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);

        // 최단경로 복원을 위한 이전 노드 배열
        int[] prev = new int[n];
        Arrays.fill(prev, -1);

        // 누적 거리가 작은 State가 먼저 나오도록 설정
        PriorityQueue<State> pq = new PriorityQueue<>((a, b) ->
                Integer.compare(a.dist, b.dist));

        // 시작점 초기화
        dist[start] = 0;
        pq.offer(new State(start, 0));

        // Dijkstra
        while (!pq.isEmpty()) {
            State cur = pq.poll();

            // stale entry
            // 이미 더 좋은 경로가 발견된, 오래된 정보라면 무시
            if (cur.dist > dist[cur.node]) {
                continue;
            }

            // 현재 노드에서 갈 수 있는 모든 간선 확인
            for (Edge edge : graph[cur.node]) {
                int next = edge.to;
                int newDist = cur.dist + edge.weight;

                // Relaxation
                if (newDist < dist[next]) {
                    dist[next] = newDist; // 거리 갱신

                    // 최단경로 복원을 위해 next에 오기 직전 노드 기록
                    prev[next] = cur.node; // 경로 기록

                    pq.offer(new State(next, newDist)); // 다시 탐색 후보에 추가
                }
            }
        }

        return new Result(dist, prev);
    }

    // prev[]를 이용해서 start -> end 경로 복원
    static List<Integer> getPath(
            int start,
            int end,
            int[] prev,
            int[] dist
    ) {
        // 도달할 수 없는 경우
        if (dist[end] == Integer.MAX_VALUE) {
            return Collections.emptyList();
        }

        List<Integer> path = new ArrayList<>();

        // end부터 이전 노드를 거꾸로 따라감
        for (int node = end; node != -1; node = prev[node]) {
            path.add(node);
        }

        // end -> ... -> start 상태이므로 뒤집기
        Collections.reverse(path);

        return path;
    }

    public static void main(String[] args) {

        // 노드: 1 ~ 5
        int n = 5;

        List<Edge>[] graph = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        // 방향 그래프
        //
        // 1 --2--> 2
        // 1 --5--> 3
        // 2 --1--> 3
        // 2 --4--> 4
        // 3 --1--> 4
        // 4 --2--> 5

        graph[1].add(new Edge(2, 2));
        graph[1].add(new Edge(3, 5));

        graph[2].add(new Edge(3, 1));
        graph[2].add(new Edge(4, 4));

        graph[3].add(new Edge(4, 1));

        graph[4].add(new Edge(5, 2));

        int start = 1;
        int end = 5;

        // Dijkstra 실행
        Result result = dijkstra(graph, start);

        // 최단거리
        System.out.println(
                "Shortest distance: " + result.dist[end]
        );

        // 실제 최단경로 복원
        List<Integer> path =
                getPath(start, end, result.prev, result.dist);

        System.out.println(
                "Shortest path: " + path
        );
    }
}