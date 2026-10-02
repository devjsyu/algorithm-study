import java.util.*;

public class Kruskal {

    public record Edge(int from, int to, int weight) {}

    public record Result(long cost, List<Edge> edges) {}

    public static Result kruskal(int n, List<Edge> edges) {
        // 1. 간선을 가중치 기준 오름차순 정렬
        edges.sort(Comparator.comparingInt(Edge::weight));

        UnionFind uf = new UnionFind();

        long totalCost = 0;
        List<Edge> mst = new ArrayList<>();

        // 2. 가장 저렴한 간선부터 확인
        for (Edge edge : edges) {

            // 3. 서로 다른 컴포넌트라면 연결
            //  -> 사이클을 만들지 않는 간선
            if (uf.union(edge.from(), edge.to())) {
                mst.add(edge);
                totalCost += edge.weight();

                // MST는 정확히 n - 1개의 간선을 가짐
                if (mst.size() == n - 1) {
                    break;
                }
            }
        }

        // 모든 정점을 연결할 수 없는 그래프
        if (mst.size() != n - 1) {
            return null;
        }

        return new Result(totalCost, mst);
    }

    private static class UnionFind {

        private final int[] parent;
        private final int[] size;

        UnionFind(int n) {
            parent = new int[n];
            size = new int[n];

            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = i;
            }
        }

        // Path Compression
        int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }

            return parent[x];
        }

        // Union by Size
        // 합쳐졌으면 true
        // 이미 같은 집합이면 false
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