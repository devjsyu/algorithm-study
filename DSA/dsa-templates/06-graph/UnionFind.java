/**
 * Union-Find (Disjoint Set Union, DSU)
 *
 * Consider when:
 * - 원소들이 같은 그룹에 속하는지 빠르게 확인해야 한다.
 * - 두 그룹을 반복적으로 합쳐야 한다.
 * - 그래프의 연결 여부 / connected components를 관리해야 한다.
 *
 * Optimizations:
 * - Path Compression
 * - Union by Size
 *
 * Complexity:
 * - find / union: amortized O(a(N))
 * -> 실질적으로 거의 O(1)
 * - Space: O(N)
 */
public class UnionFind {

    private final int[] parents;
    private final int[] size;
    private int components;

    public UnionFind(int n) {
        parent = new int[n];
        size = new int[n];
        components = n;

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    // x가 속한 집합의 대표(root)를 반환
    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]); // Path Compression
        }

        return parent[x];
    }

    // 두 집합을 합친다.
    // 이미 같은 집합이면 false
    public boolean union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        if (rootA == rootB) {
            return false;
        }

        // Union by Size:
        // 작은 트리를 큰 트리 밑에 붙인다.
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