import java.util.Arrays;

class Solution {
    private int[] parent;

    // 1. find 연산 (경로 압축 적용)
    private int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    // 2. union 연산 (사이클 판별 및 병합)
    private boolean union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        // 이미 같은 집합(루트가 같음)이면 사이클 발생
        if (rootA == rootB) return false;

        // 서로 다른 집합이면 병합
        parent[rootB] = rootA;
        return true;
    }

    public int solution(int n, int[][] costs) {
        // 1. 간선 비용(costs[i][2]) 기준 오름차순 정렬
        Arrays.sort(costs, (a, b) -> Integer.compare(a[2], b[2]));

        // 2. Union-Find 부모 배열 초기화
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        int totalCost = 0;
        int edgeCount = 0;

        // 3. 가장 저렴한 간선부터 순회하며 사이클이 없을 때만 선택
        for (int[] edge : costs) {
            int u = edge[0];
            int v = edge[1];
            int cost = edge[2];

            if (union(u, v)) {
                totalCost += cost;
                edgeCount++;

                // n개의 정점을 잇는 데 필요한 간선(n - 1)을 모두 찾으면 조기 종료
                if (edgeCount == n - 1) {
                    break;
                }
            }
        }

        return totalCost;
    }
}