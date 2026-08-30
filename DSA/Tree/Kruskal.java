import java.util.Arrays;

public class Kruskal {

    // 간선 정보를 담기 위한 클래스
    static class Edge implements Comparable<Edge> {
        int nodeA;
        int nodeB;
        int cost;

        public Edge(int nodeA, int nodeB, int cost) {
            this.nodeA = nodeA;
            this.nodeB = nodeB;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge other) {
            return Integer.compare(this.cost, other.cost);
        }
    }

    static class UnionFind {
        int[] parent;

        public UnionFind(int size) {
            parent = new int[size + 1]; // 노드 번호가 1번부터 시작한다고 가정
            for (int i = 1; i <= size; i++) {
                parent[i] = i;
            }
        }

        public int find(int x) {
            if (parent[x] == x) return x;
            return parent[x] = find(parent[x]); // 경로 압축
        }

        public void union(int a, int b) {
            int rootA = find(a);
            int rootB = find(b);

            if (rootA != rootB) {
                parent[rootB] = rootA;
            }
        }
    }

    public static void main(String[] args) {
        int v = 5; // 노드의 개수 (1번 ~ 5번)

        Edge[] edges = {
                new Edge(1, 2, 3),
                new Edge(1, 4, 7),
                new Edge(2, 3, 1),
                new Edge(2, 4, 4),
                new Edge(2, 5, 5),
                new Edge(3, 5, 2),
                new Edge(4, 5, 6)
        };

        // 간선을 비용 기준으로 오름차순 정렬
        Arrays.sort(edges);

        UnionFind uf = new UnionFind(v);
        int totalCost = 0;
        int edgeCount = 0;

        // 정렬된 간선을 하나씩 꺼내면서 확인
        for (Edge edge : edges) {
            // 두 노드의 최고 팀장이 다르다? 아직 연결되지 않았다! 사이클이 생기지 않는다!
            if (uf.find(edge.nodeA) != uf.find(edge.nodeB)) {
                uf.union(edge.nodeA, edge.nodeB); // 두 노드를 합침
                totalCost += edge.cost; // 비용 누적 집계
                edgeCount++;

                // 간선의 수가 (정점의 수 - 1)개가 되면 모든 정점이 연결된 것이므로 종료
                if (edgeCount == v - 1) break;
            }
        }

        System.out.println("최소 연결 비용: " + totalCost);
    }
}