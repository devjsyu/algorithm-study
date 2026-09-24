/**
Dijkstra algorithm
다익스트라 알고리즘 기본 가정에 위배되는 건가? 전형적인 다익스트라 알고리즘에서 문제 조건에 맞춰 변형해야 한다.
성공 확률이 높을수록 좋은 것. 성공 확률이 가장 높은 것을 반환해야 한다.
가중치(성공 확률)가 높은 것을 우선하도록 해야 한다.
확률 곱셈 연산을 통해 거리 계산
 */
class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        // 그래프 초기화
        List<Edge>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < edges.length; i++) {
            int v1 = edges[i][0];
            int v2 = edges[i][1];
            
            graph[v1].add(new Edge(v2, succProb[i]));
            graph[v2].add(new Edge(v1, succProb[i]));
        }

        return dijkstra(graph, n, edges, succProb, start_node, end_node);
    }

    public record Edge(int to, double weight) {}

    public record State(int node, double dist) {}

    private double dijkstra(List<Edge>[] graph, int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        // maxHeap
        PriorityQueue<State> pq = new PriorityQueue<>((a, b) -> Double.compare(b.dist, a.dist));
        double[] dist = new double[n];
        Arrays.fill(dist, -1);

        pq.offer(new State(start_node, 1));

        while (!pq.isEmpty()) {
            State cur = pq.poll();

            // stale data check
            if (dist[cur.node] > cur.dist) {
                continue;
            }

            for (Edge edge : graph[cur.node]) {
                int next = edge.to;
                double newDist = edge.weight * cur.dist;

                if (dist[next] < newDist) {
                    dist[next] = newDist;

                    pq.offer(new State(next, newDist));
                }
            }
        }

        return dist[end_node] == -1 ? 0 : dist[end_node];
    }
}