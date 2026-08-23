public class UnionFind {
    static int[] parent;

    // 초기화: 자기 자신을 부모로 설정
    static void init(int n) {
        parent = new int[];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    // find 연산 (경로 압축 적용)
    static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]); // 부모 노드를 루트 노드로 갱신
    }

    // union 연산: 합치는 데 성공하면 true, 이미 같은 집합이면 false
    static boolean union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        if (rootA == rootB) return false; // 사이클 발생 (이미 같은 집합)

        parent[rootB] = rootA; // b의 루트를 a의 루트 밑으로 병합
        return true;
    }
}