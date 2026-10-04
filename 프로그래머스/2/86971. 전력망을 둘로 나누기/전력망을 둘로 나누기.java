/**
- tree : connected, acyclic, undirected graph
- 사이클이 없기 때문에, 간선 하나를 끊으면 기존 단일 컴포넌트가 두 개의 컴포넌트를 무조건 나뉘는 것이 보장된다.
- 기존 전선의 개수는 고정되어 있으니, 나뉘어진 하나의 컴포넌트 속 전선 개수를 구하면 나머지 컴포넌트의 전선 개수를 자동으로 구할 수 있다.
- 문제에서는 부모 노드를 지정하지 않았다.
*/
import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {
        // 그래프 초기화
        List<Integer>[] graph = new ArrayList[n + 1]; // 1-indexed
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] wire : wires) {
            int a = wire[0];
            int b = wire[1];
            
            graph[a].add(b);
            graph[b].add(a);
        }
        
        int min = Integer.MAX_VALUE;
        
        // 모든 전선에 대해 순회하며 완전탐색하기
        for (int[] wire : wires) {
            int a = wire[0];
            int b = wire[1];
            
            // 임의로 전선 끊어보기
            graph[a].remove(Integer.valueOf(b));
            graph[b].remove(Integer.valueOf(a));
            
            // 끊어진 그래프에 대해 BFS를 통해 컴포넌트별 노드 개수 구하기
            int nodeCountOfOneComponent = bfs(graph, n, a);
            int nodeCountOfTheOtherComponent = n - nodeCountOfOneComponent;
            
            // 최솟값 갱신하기
            min = Math.min(min, Math.abs(nodeCountOfOneComponent - nodeCountOfTheOtherComponent));
    
            // 끊어놓은 전선 복구하기
            graph[a].add(b);
            graph[b].add(a);
        }
        
        return min;
    }

    // 주어진 그래프 속 시작 노드로부터 그래프 탐색하며 노드의 개수 반환 
    private int bfs(List<Integer>[] graph, int n, int start) {
        int wireCount = 0;
        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[n + 1]; // 1-indexed
        
        queue.offer(start);
        visited[start] = true;
        wireCount++;
        
        while (!queue.isEmpty()) {
            int current = queue.poll();
            
            for (int next : graph[current]) {
                if (visited[next]) {
                    continue;
                }
                
                queue.offer(next);
                visited[next] = true;
                wireCount++;
            }
        }
        
        return wireCount;
    }
}