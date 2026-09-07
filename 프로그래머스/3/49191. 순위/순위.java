/**
정확하게 순위를 매길 수 있는 조건
- 이긴 횟수 + 진 횟수 = n - 1

선수와 선수 간 이기고 진 것에 대한 관계는 그래프로 나타낼 수 있다.
A 선수가 B 선수를 이겼다에 대한 해석은 directional graph일 때 가능하다.
일반적인 HashMap 형태로 구현된 directional graph에서는 out node만 저장하기 때문에, 
한 그래프를 두 가지 방식으로 해석하기 어렵다. 
따라서 이긴 관계에 대한 그래프 따로, 진 관계에 대한 그래프 따로 만들어야 한다. 

각 선수에 대해 winGraph와 loseGraph에서 각 선수로부터 출발하는 BFS 탐색을 하면,
해당 선수의 이긴 횟수와 진 횟수를 알 수 있다.
*/

import java.util.*;

class Solution {
    public int solution(int n, int[][] results) {
        // 그래프 초기화
        List<List<Integer>> winGraph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            winGraph.add(new ArrayList<>());
        }
        
        List<List<Integer>> loseGraph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            loseGraph.add(new ArrayList<>());
        }
        
        for (int[] result : results) {
            winGraph.get(result[0]).add(result[1]);
            loseGraph.get(result[1]).add(result[0]);
        }
        
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            int winCount = bfs(i, winGraph, n);
            int loseCount = bfs(i, loseGraph, n);
            
            if (winCount + loseCount == n - 1) {
                answer++;    
            }
        }
        
        return answer;
    }
    
    // 인자로 주어진 해당 선수가 이기거나 진 횟수를 반한
    private int bfs(int player, List<List<Integer>> graph, int n) {
        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[n + 1];
        
        queue.add(player);
        visited[player]= true;
        
        int count = 0;
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            
            for (int neighbor : graph.get(curr)) {
                if (!visited[neighbor]) {
                    queue.add(neighbor);
                    visited[neighbor] = true;
                    count++;
                }
            }
        }
        
        return count;
    }
}