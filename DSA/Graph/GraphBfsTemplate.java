import java.util.*;

class GraphBfsTemplate {
    static List<Integer>[] graph;
    static boolean[] visited;

    static void bfs(int start) {
        Queue<Integer> queue = new ArrayDeque<>();

        queue.offer(start);
        visited[start] = true;

        while (!queue.isEmtpy()) {
            int current = queue.poll();

            for (int next : graph[current]) {
                if (visited[next]) continue;

                queue.offer(next);
                visited[next] = true;
            }
        }
    }
}