import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {        
        // 인접 리스트 초기화
        adjacencyList = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adjacencyList[i] = new ArrayList<>();
        }
        
        // computers 배열 순회를 통한 그래프 초기화
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (computers[i][j] == 1) {
                    addEdge(i, j);
                }
            }
        }
        
        // 방문 여부 관리할 배열 초기화
        boolean[] visited = new boolean[n];

        int count = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                bfs(i, adjacencyList, visited);
                count++;
            }
        }
        
        return count;
    }
    
    // field for Adjacency List
    private List<Integer>[] adjacencyList;
    
    // method for adding edges
    // undirectional graph
    private void addEdge(int v1, int v2) {
        this.adjacencyList[v1].add(v2);
        this.adjacencyList[v2].add(v1);
    }
    
    // method for BFS algorithm
    private void bfs(int start, List<Integer>[] adjacencyList, boolean[] visited) {
        Queue<Integer> queue = new ArrayDeque<>();
        
        queue.offer(start);
        visited[start] = true;
        
        while (!queue.isEmpty()) {
            int current = queue.poll();
            
            for (int neighbor : adjacencyList[current]) {
                if (visited[neighbor]) continue;
                
                visited[neighbor] = true;
                queue.offer(neighbor);
            }
        }
    }
}