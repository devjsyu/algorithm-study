import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        BFS graph = new BFS();

        for (int[] undirectionalEdge : edge) {
            graph.addEdge(undirectionalEdge[0], undirectionalEdge[1]);
        }

        return graph.bfs(1, n);
    }

    private static class BFS {
        private Map<Integer, List<Integer>> adjacencyList;

        public BFS() {
            this.adjacencyList = new HashMap<>();
        }

        private void addVertex(Integer vertex) {
            adjacencyList.putIfAbsent(vertex, new ArrayList<>());
        }

        // undirectional graph
        private void addEdge(Integer source, Integer destination) {
            this.addVertex(source);
            this.addVertex(destination);
            adjacencyList.get(source).add(destination);
            adjacencyList.get(destination).add(source);
        }

        private int bfs(Integer startVertex, int n) {
            Queue<Integer> queue = new ArrayDeque<>();
            int[] dist = new int[n + 1];
            Arrays.fill(dist, -1); // -1은 미방문 상태

            queue.add(startVertex);
            dist[startVertex] = 0;

            int maxDist = 0;

            while (!queue.isEmpty()) {
                int currentVertex = queue.poll();

                for (int neighbor : adjacencyList.getOrDefault(currentVertex, Collections.emptyList())) {
                    if (dist[neighbor] == -1) {
                        dist[neighbor] = dist[currentVertex] + 1;
                        maxDist = Math.max(maxDist, dist[neighbor]);
                        queue.add(neighbor);
                    }
                }
            }

            int count = 0;
            for (int i = 1; i <= n; i++) {
                if (dist[i] == maxDist) {
                    count++;
                }
            }
            
            return count;
        }
    }
}