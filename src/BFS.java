import java.util.*;

public class BFS {
    // Adjacency list representation of the graph
    private Map<String, List<String>> adjacencyList;

    public BFS() {
        this.adjacencyList = new HashMap<>();
    }

    // Add an edge to the graph (directed)
    public void addEdge(String source, String destination) {
        this.addVertex(source);
        this.addVertex(destination);
        adjacencyList.get(source).add(destination);
    }

    // Core BFS Implementation
    public void bfs(String startVertex) {
        if (!adjacencyList.containsKey(startVertex)) {
            System.out.println("Start vertex not found in graph");
            return;
        }

        // Initialize a queue to manage the order of traversal
        Queue<String> queue = new LinkedList<>();

        // Initialize a set to keep track of visited vertices
        Set<String> visited = new HashSet<>();

        // Enqueue the starting node and mark it as visited
        queue.add(startVertex);
        visited.add(startVertex);

        System.out.print("BFS Traversal starting from " + startVertex + ": ");

        // Loop while the queue is not empty
        while (!queue.isEmpty()) {
            // Dequeue a vertex from the front of the queue
            String currentVertex = queue.poll();
            System.out.print(currentVertex + " ");

            // Explore all unvisited neighbors of the current vertex
            for (String neighbor : adjacencyList.getOrDefault(currentVertex, Collections.emptyList())) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor); // Mark as visited
                    queue.add(neighbor); // Enqueue neighbor
                }
            }
        }
        System.out.println();
    }
}