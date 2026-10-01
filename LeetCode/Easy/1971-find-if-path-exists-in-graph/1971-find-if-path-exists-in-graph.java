/**
Is the vertex A connected with the vertex B?
 */
class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        this.parent = new int[n];
        this.size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }

        for (int i = 0; i < edges.length; i++) {
            int a = edges[i][0];
            int b = edges[i][1];

            union(a, b);
        }

        return find(source) == find(destination);
    }

    private int[] parent;
    private int[] size;

    private int find(int x) {
        if (parent[x] != x) {
            // Path Compression
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

        // Union by Size
        // 작은 집합을 큰 집합에 합병하기
        if (size[rootA] < size[rootB]) {
            int temp = rootA;
            rootA = rootB;
            rootB = temp;
        }

        parent[rootB] = rootA;
        size[rootA] += size[rootB];

        return true;
    }
}