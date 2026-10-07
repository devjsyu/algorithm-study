class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        this.parent = new int[n];
        this.size = new int[n];
        this.components = n;

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
        
        
        for (int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];

            union(a, b);
        }

        return find(source) == find(destination);
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