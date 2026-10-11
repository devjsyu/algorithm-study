// MST
// Kruskal algorithm
import java.util.*;

class Solution {
    public int solution(int n, int[][] costs) {
        this.parent = new int[n];
        this.size = new int[n];
        
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
        
        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(Edge::weight));
        
        for (int[] cost : costs) {
            int a = cost[0];
            int b = cost[1];
            int weight = cost[2];
            
            pq.offer(new Edge(a, b, weight));
        }
        
        int totalWeight = 0;
        int mstEdges = 0;
        while (!pq.isEmpty()) {
            Edge current = pq.poll();
            int a = current.from();
            int b = current.to();
            int weight = current.weight();
            
            if (union(a, b)) {
                totalWeight += weight;
                mstEdges++;
                
                if (mstEdges == n - 1) {
                    return totalWeight;
                }
            }
        }
                
        return -1;
    }
    
    public record Edge(int from, int to, int weight) {}
    
    private int[] parent;
    private int[] size;
    
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
        
        return true;
    }
}