import java.util.*;

public class GraphBFSTemplate {

    public static void main(String[] args) {
        int n = 6;

        // 1. Build adjacency list
        List<Integer>[] graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        // Example: undirected graph
        addEdge(graph, 0, 1);
        addEdge(graph, 0, 2);
        addEdge(graph, 1, 3);
        addEdge(graph, 2, 4);
        addEdge(graph, 4, 5);

        // 2. Run BFS
        bfs(graph, 0);
    }

    private static void addEdge(
            List<Integer>[] graph,
            int u,
            int v
    ) {
        graph[u].add(v);
        graph[v].add(u);
    }

    private static void bfs(
            List<Integer>[] graph,
            int start
    ) {
        boolean[] visited = new boolean[graph.length];
        Queue<Integer> queue = new ArrayDeque<>();

        // Mark visited when enqueuing
        visited[start] = true;
        queue.offer(start);

        while (!queue.isEmpty()) {
            int current = queue.poll();

            // Process current node
            System.out.println(current);

            for (int next : graph[current]) {
                if (visited[next]) {
                    continue;
                }

                visited[next] = true;
                queue.offer(next);
            }
        }
    }

    private static int[] bfsShortestDistance(
            List<Integer>[] graph,
            int start
    ) {
        int[] dist = new int[graph.length];
        Arrays.fill(dist, -1);

        Queue<Integer> queue = new ArrayDeque<>();

        dist[start] = 0;
        queue.offer(start);

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int next : graph[current]) {
                if (dist[next] != -1) {
                    continue;
                }

                dist[next] = dist[current] + 1;
                queue.offer(next);
            }
        }

        return dist;
    }
}