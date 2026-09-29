import java.util.*;

class Solution {
    public int minTimeToReach(int[][] moveTime) {
        return dijkstra(moveTime);
    }

    private static final int[] dr = {-1, 1, 0, 0};
    private static final int[] dc = {0, 0, -1, 1};

    public record State(int row, int col, int time) {}

    private int dijkstra(int[][] moveTime) {        
        int rows = moveTime.length;
        int cols = moveTime[0].length;

        int[][] dist = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                dist[i][j] = Integer.MAX_VALUE;
            }
        }

        boolean[][] visited = new boolean[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                visited[i][j] = false;
            }
        }

        PriorityQueue<State> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.time(), b.time()));

        pq.offer(new State(0, 0, 0));
        dist[0][0] = 0;
        visited[0][0] = true;

        while (!pq.isEmpty()) {
            State cur = pq.poll();

            for (int d = 0; d < 4; d++) {
                int nr = cur.row() + dr[d];
                int nc = cur.col() + dc[d];
                int newTime = 0;

                // filtering the out of grid case
                if (nr < 0 || nr >= rows || nc < 0 || nc >= cols) {
                    continue;
                }

                if (visited[nr][nc]) {
                    continue;
                }

                if (moveTime[nr][nc] > cur.time()) {
                    newTime = moveTime[nr][nc] + 1;
                } else {
                    newTime = cur.time() + 1;
                }

                dist[nr][nc] = newTime;

                if (nr == rows - 1 && nc == cols -1) {
                    return dist[nr][nc];
                }

                pq.offer(new State(nr, nc, newTime));
                visited[nr][nc] = true;
            }
        }

        return -1;
    }
}