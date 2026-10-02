// edge가 명시적으로 주어지지 않았다.
// 모든 가능한 edge의 조합을 만들기 위해 O(N^2) 시간복잡도가 필요하다.
// manhattan distance가 가장 적은 edge가 무엇인지 알 수 있다면, O(N^2)까지는 필요 없을 것이다.
// Kruskal 알고리즘을 할 때, edge의 weight가 가장 적은 것부터 선택되기 때문이다.

// 우선, 모든 edge 조합을 brute-force로 구하고 Kruskal 알고리즘 적용하기
import java.util.*;

class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        List<Edge> edges = new ArrayList<>();
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int val = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
                edges.add(new Edge(i, j, val));
            }
        }
        Collections.sort(edges, (a, b) -> Integer.compare(a.weight(), b.weight()));

        UnionFind uf = new UnionFind(n);
        
        int totalCost = 0;
        List<Edge> mst = new ArrayList<>();

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
        private int[] parent;
        private int[] size;

        UnionFind(int n) {
            this.parent = new int[n];
            this.size = new int[n];

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
            size[rootA] += size[rootB];

            return true;
        }
    }
}