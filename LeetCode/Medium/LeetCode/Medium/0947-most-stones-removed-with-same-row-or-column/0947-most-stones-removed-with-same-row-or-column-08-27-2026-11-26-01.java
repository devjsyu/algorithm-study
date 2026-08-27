class Solution {
    static int[] parent;
    static int componentCount;
    
    public int removeStones(int[][] stones) {
        // 서로소 그래프 컴포넌트를 구하기 위해 Union-Find를 활용하기
        
        // 초기화
        int n = stones.length;
        componentCount = n;
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        // 모든 경우의 수 순회하기
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                // 제거 조건을 만족하는 좌표일 경우
                if (stones[i][0] == stones[j][0] 
                || stones[i][1] == stones[j][1]) {
                    union(i, j);
                }
            }
        }
        
        // 전체 개수 - 서로소 그래프 컴포넌트의 개수
        return n - componentCount;
    }

    static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        // 서로 다른 그룹일 때 병합 후 
        if (rootA != rootB) {
            parent[rootA] = rootB;
            componentCount--;
        }
    }
}