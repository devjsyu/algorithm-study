public class UnionFindExample {
    private final int[] parent;
    private final int[] rank;

    // Initialize the Union-Find data structure with N elements
    public UnionFindExample(int n) {
        parent = new int[n];
        rank = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i; // Initially, every element is its own parent
            rank[i] = 0; // Initial rank (tree height approximation) is 0
        }
    }

    // Find the representative (root) of the set that element 'i' belongs
    // Includes Path Compression optimization
    public int find(int i) {
        if (parent[i] == i) {
            return i;
        }

        // Path Compression: Make the node point directly to the actual root
        return parent[i] = find(parent[i]);
    }

    // Merge the sets containing element 'x' and element 'y'
    // Includes Union by Rank optimization
    public boolean union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        // They are already in the same set
        if (rootX == rootY) {
            return false;
        }

        // Union by Rank: Attach the smaller depth tree under the root of the deeper tree
        if (rank[rootX] < rank[rootY]) {
            parent[rootX] = rootY;
        } else if (rank[rootX] > rank[rootY]) {
            parent[rootY] = rootX;
        } else {
            parent[rootY] = rootX;
            rank[rootX]++; // If ranks are the same, increment the new root's rank
        }

        return true; // Successfully merged two distinct sets
    }
}