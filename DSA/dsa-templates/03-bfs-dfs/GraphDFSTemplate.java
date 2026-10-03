import java.util.*;

public class GraphDFSTemplate {

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

        // 2. Run DFS
        boolean[] visited = new boolean[n];
        for (int node = 0; node < n; node++) { // connected components
            if (visited[node]) {
                continue;
            }

            dfs(graph, node, visited);
        }
    }

    private static void addEdge(
            List<Integer>[] graph,
            int u,
            int v
    ) {
        graph[u].add(v);
        graph[v].add(u);
    }

    private static void dfs(
            List<Integer>[] graph,
            int start,
            boolean[] visited
    ) {
        Deque<Integer> stack = new ArrayDeque<>();

        // Mark current node as visited
        visited[start] = true;
        stack.push(start);

        while (!stack.isEmpty()) {
            int current = stack.pop();

            // Process current node
            System.out.println(current);

            // Explore neighbors
            for (int next : graph[current]) {
                if (visited[next]) {
                    continue;
                }

                visited[next] = true;
                stack.push(next);
            }
        }
    }
}