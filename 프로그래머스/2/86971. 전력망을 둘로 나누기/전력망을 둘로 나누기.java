import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {
        this.n = n;
        this.adjacencyList = new ArrayList[n + 1]; // 1-indexed
        for (int i = 1; i <= n; i++) {
            adjacencyList[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < wires.length; i++) {
            addEdge(wires[i][0], wires[i][1]);
        }
        
        int min = Integer.MAX_VALUE;
        int abs;
        for (int i = 0; i < wires.length; i++) {
            // 끊기
            adjacencyList[wires[i][0]].remove(Integer.valueOf(wires[i][1]));
            adjacencyList[wires[i][1]].remove(Integer.valueOf(wires[i][0]));            

            int count = dfs(i + 1); // 1-index
            
            abs = Math.abs(n - count - count);
            if (min > abs) {
                min = abs;
            }
            
            // 복구
            addEdge(wires[i][0], wires[i][1]);
        }

        return min;
    }
    
    private int n;
    private List<Integer>[] adjacencyList;    
    
    private void addEdge(int v1, int v2) {
        adjacencyList[v1].add(v2);
        adjacencyList[v2].add(v1);
    }
    
    // 해당 노드를 부모 노드로 하는 그래프의 총 노드 개수 반환
    private int dfs(int start) {
        Deque<Integer> stack = new ArrayDeque<>();
        boolean[] visited = new boolean[n + 1];
        int count = 0;
        
        stack.push(start);
        visited[start] = true;
        count++;
        
        while (!stack.isEmpty()) {
            int current = stack.pop();
            
            for (int next : adjacencyList[current]) {
                if (!visited[next]) {
                    stack.push(next);
                    visited[next] = true;
                    count++;
                } 
            }
        }
        
        return count;
    }
}