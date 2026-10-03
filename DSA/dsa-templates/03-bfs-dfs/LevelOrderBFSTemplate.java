import java.util.*;

public class LevelOrderBFSTemplate {

    public static void levelOrderBfs(
            List<Integer>[] graph,
            int start
    ) {
        boolean[] visited = new boolean[graph.length];
        Queue<Integer> queue = new ArrayDeque<>();

        visited[start] = true;
        queue.offer(start);

        int level = 0;

        while (!queue.isEmpty()) {

            // Nodes currently in the queue belong to this level
            int levelSize = queue.size();

            for (int i = 0; i < levelSize; i++) {
                int current = queue.poll();

                // Process current node

                for (int next : graph[current]) {
                    if (visited[next]) {
                        continue;
                    }

                    visited[next] = true;
                    queue.offer(next);
                }
            }

            // Current level is completely processed
            level++;
        }
    }
}