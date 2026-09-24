import java.util.*;

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        this.dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        this.prev = new int[n + 1];
        Arrays.fill(prev, -1);

        // 그래프 초기화
        this.graph = new ArrayList[n + 1]; // 1-indexed
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] time : times) {
            int source = time[0];
            int destination = time[1];
            int weight = time[2];

            graph[source].add(new Edge(destination, weight));    
        }
        
        // 다익스트라 알고리즘을 통해 dist[], prev[] 업데이트
        dijkstra(k);

        // 조기 반환
        // 하나라도 도달하지 못하는 케이스 있는지 검사
        for (int i = 1; i <= n; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                return -1;
            }
        }

        // 최소 도달 시간 중 최댓값 구하기
        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            max = Math.max(max, dist[i]);
        }

        return max;
    }

    private List<Edge>[] graph;
    private int[] dist;
    private int[] prev;
    private int source;

    public record Edge(int to, int weight) {}

    public record State(int node, int dist) {}

    private void dijkstra(int source) {
        PriorityQueue<State> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.dist, b.dist));
        
        pq.offer(new State(source, 0));
        dist[source] = 0;

        while (!pq.isEmpty()) {
            State cur = pq.poll();

            // stale entry check
            if (dist[cur.node] < cur.dist) {
                continue;
            }

            for (Edge next : graph[cur.node]) {
                // relaxation
                int newDist = cur.dist + next.weight;

                if (dist[next.to] > newDist) {
                    dist[next.to] = newDist;

                    pq.offer(new State(next.to, newDist));
                    prev[next.to] = cur.node;
                }
            }
        }
    }
}