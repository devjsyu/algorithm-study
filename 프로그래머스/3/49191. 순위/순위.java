/**
- 플로이드 워셜 : directional graph 1개를 두 가지 방법으로 해석
- BFS : directional graph 2개를 각각 winGraph, loseGraph로 해석
    - BFS에서 adjacencyList는 out-edge만을 저장하기 때문이다. 
    
- 주어진 배열을 두 번 순회하면서 winGraph와 loseGraph를 초기화한다.    
- 각 노드를 순회하면서 winGraph, loseGraph에서 각각 확실히 알 수 있는 것을 누적 집계한다.
- 누적 집계된 값이 n - 1이라면 모든 승패를 알 수 있게 된다.
- 해당 경우의 수를 누적 집계하여 반환한다.
*/
import java.util.*;

class Solution {
    public int solution(int n, int[][] results) {
        // 전체 인접 리스트 초기화
        List<List<Integer>> winGraph = new ArrayList<>();
        List<List<Integer>> loseGraph = new ArrayList<>();
        
        // 각 노드에 대한 인접 리스트 초기화
        for (int i = 0; i <= n; i++) {
            winGraph.add(new ArrayList<>());
            loseGraph.add(new ArrayList<>());
        }
        
        // 모든 경기 결과 순회하면서 전체 인접 리스트 업데이트
        for (int[] result : results) {
            winGraph.get(result[0]).add(result[1]);
            loseGraph.get(result[1]).add(result[0]);
        }
        
        // 모든 노드에 대해 순회
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            // 각 노드별 이기고 진 횟수 집계
            int winCount = bfs(i, winGraph, n);
            int loseCount = bfs(i, loseGraph, n);
            
            // 이긴 횟수와 진 횟수의 합이 n - 1이 되는 경우를 집계
            if (winCount + loseCount == n - 1) {
                answer++;
            }
        }

        return answer;
    }
    
    private int bfs(int start, List<List<Integer>> graph, int n) {
        boolean[] visited = new boolean[n + 1];
        Queue<Integer> queue = new ArrayDeque<>();
        
        queue.offer(start);
        visited[start] = true;
        int count = 0;
        
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            
            for (int next : graph.get(curr)) {
                if (!visited[next]) {
                    visited[next] = true;
                    count++;
                    queue.offer(next);
                }
            }
        }
        
        return count;
    }
}