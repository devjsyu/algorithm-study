## note
### Analysis
> 1번 노드에서 출발해 최단 경로로 이동했을 때, 간선의 개수가 가장 많은 노드들의 개수를 구하시오.
- **접근 방식:** 1번 노드부터 BFS로 탐색하며 각 노드까지의 최단 거리를 기록하고, 최댓값에 해당하는 노드의 개수를 센다.
- **DFS 대신 BFS를 사용하는 이유:**
    - 모든 간선의 가중치가 동일할 때, BFS는 **큐에 들어온 순서대로 탐색하므로 노드에 처음 도달했을 때의 깊이가 곧 최단 경로**임이 보장된다.
    - DFS로 최단 경로를 구하려면 방문 체크를 풀면서 모든 경로를 완전 탐색해야 하므로 비효율적이다.

### How I solved
1. 양방향 그래프를 인접 리스트(`List<Integer>[]`) 형태로 구축한다.
2. 미방문 상태(`-1`)를 나타내는 거리 배열(`dist[]`)을 초기화한다.
3. 1번 노드부터 큐에 넣고 BFS를 순회하며 `dist[neighbor] = dist[curr] + 1`로 최단 거리를 갱신한다.
4. 탐색 도중 최댓값을 추적하거나, 탐색 완료 후 최댓값의 개수를 집계하여 반환한다.

### Key Takeaway
- **가중치 없는 그래프의 최단 경로 = BFS:** '최단 거리' 키워드와 '간선 가중치 동일' 조건이 나오면 BFS를 우선 떠올린다.
- **자료구조 선택 최적화:** 정점 번호가 $1$부터 $N$까지 주어질 때는 `Map<Integer, Integer>` 대신 인덱스를 바로 쓸 수 있는 기본 배열(`int[]`)을 사용해 오토박싱 비용과 해시 충돌 오버헤드를 줄인다.

## my previous code
```java
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
```

## answer code
```java
import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        // 인접 리스트 배열 초기화
        List<Integer>[] adj = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int[] e : edge) {
            adj[e[0]].add(e[1]);
            adj[e[1]].add(e[0]);
        }

        // 거리 배열 (-1로 미방문 상태 표현)
        int[] dist = new int[n + 1];
        Arrays.fill(dist, -1);

        Queue<Integer> queue = new ArrayDeque<>();
        
        // 1번 노드 시작
        queue.offer(1);
        dist[1] = 0;

        int maxDist = 0;
        int count = 0;

        while (!queue.isEmpty()) {
            int curr = queue.poll();

            for (int neighbor : adj[curr]) {
                if (dist[neighbor] == -1) {
                    dist[neighbor] = dist[curr] + 1;
                    queue.offer(neighbor);

                    // 최대 거리 갱신 및 카운트
                    if (dist[neighbor] > maxDist) {
                        maxDist = dist[neighbor];
                        count = 1; // 새로운 최대 거리가 나오면 1부터 재카운트
                    } else if (dist[neighbor] == maxDist) {
                        count++;
                    }
                }
            }
        }

        return count;
    }
}
```