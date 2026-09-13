import java.util.*;

class GraphDfsTemplate {
    static List<Integer>[] graph; // List<Integer> 리스트를 원소로 하는 배열
    static boolean[] visited; // 방문 여부를 저장하는 배열

    static void dfs(int node) {
        visited[node] = true;

        for (int next : graph[node]) {
            if (visited[next]) continue;

            dfs(next);
        }
    }
}