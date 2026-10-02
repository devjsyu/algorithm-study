import java.util.*;

class Solution {
    public int solution(int n, int[][] costs) {
        List<Edge> edges = new ArrayList<>();
        List<Edge> mst = new ArrayList<>();
        int totalCost = 0;
        UnionFind uf = new UnionFind(n);
        
        for (int[] cost : costs) {
            edges.add(new Edge(cost[0], cost[1], cost[2]));
        }
        Collections.sort(edges, (a, b) -> Integer.compare(a.weight(), b.weight()));
        
        for (Edge edge : edges) {
            if (uf.union(edge.from(), edge.to())) {
                mst.add(edge);
                totalCost += edge.weight();
                
                if (mst.size() == n - 1) {
                    break;
                }
            }
        }
        
        return totalCost;
    }
    
    public record Edge(int from, int to, int weight) {}
    
    private static class UnionFind {
        private final int[] parent;
        private final int[] size;
        
        UnionFind(int n) {
            parent = new int[n];
            size = new int[n];
            
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }
        
        int find(int x) {
            if (parent[x] != x) {
                return parent[x] = find(parent[x]);
            }
            
            return parent[x];
        }
        
        boolean union(int a, int b) {
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
            size[rootA] += rootB;
            
            return true;
        }
    }
}