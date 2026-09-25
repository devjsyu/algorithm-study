// tree : connected, acyclic, undirected graph
// 현재 그래프는 tree이지만, root node가 지정되지 않았고, rooted tree는 아니다.
// 총 전선 개수는 고정되어 있기 때문에, 한쪽만 구하면 나머지 한쪽은 나머지로서 구할 수 있다.
import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {
        // 그래프 초기화
        List<Integer>[] graph = new ArrayList[n + 1]; // 1-index
        
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int[] wire : wires) {
            int v1 = wire[0];
            int v2 = wire[1];
            
            graph[v1].add(v2);
            graph[v2].add(v1);
        }
        
        int min = Integer.MAX_VALUE;
        
        // wires 배열 순회
        // 하나씩 끊고 복구하면서 완전탐색
        for (int[] wire : wires) {
            int v1 = wire[0];
            int v2 = wire[1];
            
            // 기존 그래프에서 특정 전선 끊어보기
            graph[v1].remove(Integer.valueOf(v2));
            graph[v2].remove(Integer.valueOf(v1));
            
            // BFS로 그래프 순회하면서 해당 그래프 속 시작 노드와 연결된 모든 노드 개수 반환
            int nodeCountGraph1 = bfs(n, graph, v1);
            int nodeCountGraph2 = n - nodeCountGraph1;
                        
            // 최솟값과 비교 및 갱신
            min = Math.min(Math.abs(nodeCountGraph2 - nodeCountGraph1), min);
            
            // 끊었던 전선 복구하기
            graph[v1].add(v2);
            graph[v2].add(v1);
        }
        
        return min;
    }
    
    private int bfs(int n, List<Integer>[] graph, int start) {
        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[n + 1]; // 1-index
        int count = 0;
        
        queue.offer(start);
        visited[start] = true;
        count++;
        
        while (!queue.isEmpty()) {
            int current = queue.poll();
            
            for (int neighbor : graph[current]) {
                if (visited[neighbor]) {
                    continue;
                }
                
                queue.offer(neighbor);
                visited[neighbor] = true;
                count++;
            }    
        }
        
        return count;
    }
}