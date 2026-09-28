import java.util.*;

class Solution {
    public int[] minimumTime(int n, int[][] edges, int[] disappear) {
        // 그래프 초기화
        List<Edge>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < edges.length; i++) {
            int v1 = edges[i][0];
            int v2 = edges[i][1];
            int weight = edges[i][2];

            graph[v1].add(new Edge(v2, weight));
            graph[v2].add(new Edge(v1, weight));
        }

        // 다익스트라
        int[] dist = dijkstra(n, graph, disappear);

        int[] answer = new int[n];
        for (int i = 0; i < n; i++) {
            answer[i] = dist[i] == Integer.MAX_VALUE ? -1 : dist[i];
        }

        return answer;
    }

    public record Edge(int to, int weight) {}

    public record State(int node, int dist) {}

    // 다익스트라
    private int[] dijkstra(int n, List<Edge>[] graph, int[] disappear) {
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);

        PriorityQueue<State> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.dist(), b.dist()));

        pq.offer(new State(0, 0));
        dist[0] = 0;

        while (!pq.isEmpty()) {
            State cur = pq.poll();

            // stale state check
            if (dist[cur.node()] < cur.dist()) {
                continue;
            }

            for (Edge edge : graph[cur.node()]) {
                int next = edge.to();
                int newDist = edge.weight() + cur.dist();

                // check if it is going to be disappeared
                if (disappear[next] <= newDist) {
                    continue;
                }

                if (dist[next] > newDist) {
                    dist[next] = newDist;

                    pq.offer(new State(next, newDist));
                }
            }
        }

        return dist;
    }
}