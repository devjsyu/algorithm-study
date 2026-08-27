class Solution {
    private static int[] parent;

    private static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    private static boolean union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        if (rootA == rootB) return false;
        parent[rootA] = rootB;
        return true;
    }

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        for (int[] edge : edges) {
            union(edge[0], edge[1]);
        }
        return find(source) == find(destination);
    }
}