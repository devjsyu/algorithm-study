## 분석

- **Dense Graph, 특히 Complete Graph에서는 일반적으로 Kruskal's Algorithm보다 Array-based Prim's Algorithm이 시간 복잡도 측면에서 유리하다.**
    - Complete Graph의 간선 수: $E = V(V-1)/2 = \Theta(V^2)$
    - Kruskal: \(O(E\log E) = $O(V^2\log V))$
    - Array-based Prim: $O(V^2)$

### Kruskal's Algorithm — Edge 중심의 Greedy

- *모든 간선을 가중치 오름차순으로 정렬하자! 가장 비용이 작은 간선부터 차례대로 확인하면서, Union-Find를 통해 사이클을 만들지 않는 간선만 MST에 추가하자! 간선이 \(V-1\)개 선택되면 종료!*
- 핵심: **전체 간선 중 최소 비용 간선부터 선택하면서 여러 컴포넌트를 병합한다.**

### Array-based Prim's Algorithm — Vertex 중심의 Greedy

- *임의의 정점 하나에서 시작해서 MST를 키워나가자! 새로 MST에 추가한 정점으로부터 아직 MST에 포함되지 않은 정점까지의 간선 비용을 확인하여 최소 연결 비용(`minDist`)을 갱신하자! 그리고 MST 밖의 정점 중 최소 연결 비용이 가장 작은 정점을 선택해서 MST를 확장하자!*
- 핵심: **현재 MST와 외부 정점 사이의 최소 비용 간선을 선택하여 하나의 트리를 확장한다.**
- `minDist[v]`: 현재 MST에 포함된 정점들과 `v`를 연결하는 간선 중 최소 가중치
- 시간 복잡도: $O(V^2)$
- 추가 공간 복잡도: $O(V)$, 간선 가중치를 필요할 때 직접 계산할 수 있는 경우

## 모범답안
```java
import java.util.*;

class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;

        if (n == 0) {
            return 0;
        }

        // minDist[v]:
        // 현재 MST와 정점 v를 연결하는 최소 간선 비용
        int[] minDist = new int[n];
        Arrays.fill(minDist, Integer.MAX_VALUE);

        // visited[v]:
        // 정점 v가 MST에 포함되었는지 여부
        boolean[] visited = new boolean[n];

        // 시작 정점은 임의로 선택 가능
        // 0번 정점을 비용 0으로 시작
        minDist[0] = 0;

        int totalWeight = 0;

        // 모든 정점을 MST에 추가할 때까지 반복
        for (int i = 0; i < n; i++) {

            // STEP 1. Select
            // 아직 MST에 포함되지 않은 정점 중
            // 최소 연결 비용을 가진 정점 u 선택
            // O(V)
            int u = -1;

            for (int v = 0; v < n; v++) {
                if (visited[v]) {
                    continue;
                }

                if (u == -1 || minDist[v] < minDist[u]) {
                    u = v;
                }
            }

            // STEP 2. Add
            // 정점 u를 MST에 추가하고 연결 비용 누적
            visited[u] = true;
            totalWeight += minDist[u];

            // STEP 3. Relaxation
            // 새로 추가된 정점 u를 이용하여
            // 나머지 정점의 최소 연결 비용 갱신
            // O(V)
            for (int v = 0; v < n; v++) {
                if (visited[v]) {
                    continue;
                }

                // Manhattan Distance
                // 인접 행렬 없이 간선 가중치를 직접 계산
                int weight =
                    Math.abs(points[u][0] - points[v][0])
                    + Math.abs(points[u][1] - points[v][1]);

                // Prim Relaxation
                if (weight < minDist[v]) {
                    minDist[v] = weight;
                }
            }
        }

        return totalWeight;
    }
}
```