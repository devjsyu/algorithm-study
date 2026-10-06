/**
Kruskal algorithm
: 그래프 속 모든 노드를 최소 비용으로 연결하는 방법
 */
import java.util.*;

class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        this.parent = new int[n];
        this.size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }

        int totalCost = 0;
        List<Edge> mst = new ArrayList<>();
        List<Edge> edges = new ArrayList<>();
        
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int val = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
                edges.add(new Edge(i, j, val));                
            }
        }

        Collections.sort(edges, (v1, v2) -> Integer.compare(v1.val(), v2.val()));

        for (Edge edge : edges) {
            if (union(edge.from(), edge.to())) {
                mst.add(edge);
                totalCost += edge.val();

                if (mst.size() == n - 1) {
                    return totalCost;
                }
            }
        }

        return 0;
    }

    public record Edge(int from, int to, int val) {}

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