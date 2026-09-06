import java.util.*;

/**
unvisited 경우에는 -1 저장하기
각 Vertex에 해당 Vertex까지 도달하기 위해 지나온 길이를 저장하기
*/
class Solution {
    public int solution(int n, int[][] edge) {
        BFS bfs = new BFS();
        
        // 그래프 초기화
        for (int[] e : edge) {
            bfs.addEdge(e[0], e[1]);
        }

        return bfs.getBfs(n);
        
    }
    
    private static class BFS {
        private Map<Integer, List<Integer>> adjacencyList;
    
        public BFS() {
            this.adjacencyList = new HashMap<>();
        }
    
        private void addEdge(int u, int v) {
            adjacencyList.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
            adjacencyList.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
        }        
        
        private int getBfs(int n) {
            // Queue 초기화
            Queue<Integer> queue = new ArrayDeque<>();
            
            // 방문 여부 확인 및 누적 길이 집계 역할 Map 초기화
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                map.put(i + 1, -1);
            }
            
            // startVertex 기준 초기화
            int startVertex = 1;
            queue.add(startVertex);
            map.put(startVertex, 0);

            // 최대 길이 저장할 변수 초기화
            int maxDistance = -1;
            
            // BFS traversal
            while (!queue.isEmpty()) {
                int currentVertex = queue.poll();
                
                for (int neighbor : adjacencyList.getOrDefault(currentVertex, Collections.emptyList())) {
                    if (map.get(neighbor) == -1) {
                        queue.add(neighbor);
                        int currentDistance = map.get(currentVertex) + 1;
                        map.put(neighbor, currentDistance);
                        if (currentDistance > maxDistance) {
                            maxDistance = currentDistance;
                        }
                    }
                }
            }
            
            // 순회하면서 원소가 최대 길이와 일치하면 누적 집계
            int count = 0;
            for (int value : map.values()) {
                if (maxDistance == value) {
                    count++;
                }
            }
            
            return count;
        }
    }
}