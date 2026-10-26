// Kruskal's algorithm
// Union-Find algorithm
import java.util.*;

class Solution {
    public int solution(int n, int[][] costs) {
        this.parent = new int[n];
        this.size = new int[n];
        
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
        
        PriorityQueue<Edge> pq = new PriorityQueue<>(
            Comparator.comparingInt(Edge::cost)
        );
        for (int[] cost : costs) {
            pq.offer(new Edge(cost[0], cost[1], cost[2]));
        }
        
        int mstEdges = 0;
        int totalCost = 0;
        
        while (!pq.isEmpty()) {
            Edge current = pq.poll();
            int a = current.a();
            int b = current.b();
            int cost = current.cost();
            
            if (union(a, b)) {
                totalCost += cost;
                mstEdges++;
                
                if (n == mstEdges - 1) {
                    return totalCost;
                }
            }
        }
        
        return totalCost;
    }
    
    private static int[] parent;
    private static int[] size;
    
    private int find(int x) {
        if (parent[x] == x) {
            return x;
        }
        return parent[x] = find(parent[x]);
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
        
        return true;
    }
    
    public record Edge(int a, int b, int cost) {}
}