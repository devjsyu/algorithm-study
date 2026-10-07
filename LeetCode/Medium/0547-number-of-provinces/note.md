### analysis

- 문제 유형:
  - Undirected graph가 adjacency matrix로 주어진다.
  - Connected components의 개수를 구하는 문제이다.
  
  
- 가능한 접근:
  - BFS/DFS:
    - 아직 방문하지 않은 node에서 traversal을 시작할 때마다 새로운 component로 집계한다.
    - 각 component 내부의 node들을 직접 탐색한다.
  - Union-Find:
    - 연결된 두 node가 서로 다른 component에 속한다면 두 component를 합친다.
    - Successful union이 발생할 때마다 component의 개수를 1 감소시킨다.
  
  
- 접근 선택:
  - BFS/DFS와 Union-Find 모두 적절한 접근이다.
  - 이 문제에서는 각 component 내부의 traversal 결과나 구체적인 reachability를 구할 필요가 없고, 연결 관계에 따라 component를 병합한 뒤 최종 component 개수만 알면 된다.
  - 따라서 component의 병합과 개수를 직접 관리하기 적합한 Union-Find를 선택한다.
  - 단, Union-Find가 BFS/DFS보다 항상 더 가볍거나 더 좋은 접근이라는 의미는 아니다.
  
  
- Union-Find:
  - 처음에는 모든 node가 독립적인 component이므로 `components = n`으로 초기화한다.
  - `isConnected[i][j] == 1`이면 `union(i, j)`를 수행한다.
  - 두 node가 이미 같은 component라면 아무 변화가 없다.
  - 서로 다른 두 component가 실제로 합쳐지는 successful union에서만 `components--` 한다.
  
  
- Adjacency matrix 순회
  - Undirected graph의 adjacency matrix는 대칭이다.
  - `isConnected[i][j] == isConnected[j][i]`이므로 `(i, j)`와 `(j, i)`는 같은 edge를 나타낸다.
  - 따라서, `j = i + 1`부터 순회하면 self-connection과 중복 edge 처리를 모두 피할 수 있다.
  

- Union-Find 최적화:
  - Path compression:
    - `find()` 과정에서 node의 parent를 root에 가깝게 변경하여 이후 `find()` 비용을 줄인다.
  - Union by size:
    - 작은 tree의 root를 큰 tree의 root 아래에 연결하여 tree가 깊어지는 것을 억제한다.
  - 두 최적화를 함께 사용한 Union-Find 연산의 amortized time complexity는 $O(\alpha(V))$이다.
  - $\alpha(V)$는 inverse Ackermann function으로 극도로 천천히 증가하므로, 현실적인 입력 범위에서는 almost $O(1)$로 생각할 수 있다.
  - 단, $O(\alpha(V))$가 수학적으로 $O(1)$이라는 의미는 아니다.
  
  
- Time Complexity:
  - Adjacency matrix traversal: $O(V^2)$
  - `find()` / `union()`: amortized $O(\alpha(V))$
  - 엄밀하게는 $O(V^2\alpha(V))$
  - $\alpha(V)$가 실질적으로 거의 상수이므로 일반적으로 $O(V^2)$로 볼 수 있다.
  

### my code
```java
/**
Union-Find algorithm를 통해 components의 개수 반환하기
 */
class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        this.parent = new int[n];
        this.size = new int[n];
        this.components = n;

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (isConnected[i][j] == 1) {
                    union(i, j);
                }
            }
        }
        
        return components;
    }

    private int[] parent;
    private int[] size;
    private int components;

    private int find(int x) {
        if (parent[x] != x) {
            return parent[x] = find(parent[x]);
        }

        return parent[x];
    }

    private boolean union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        if (rootA == rootB) {
            return false;
        }

        if (size[rootA] < size[rootB]) {
            int temp = rootA;
            rootA = rootB;
            rootB = temp;
        }

        parent[rootB] = rootA;
        size[rootA] += size[rootB];
        components--;

        return true;
    }
}
```