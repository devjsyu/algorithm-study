import java.util.*;

class GridBfsTemplate {
    static int n, m;
    static int[][] board;
    static boolean[][] visited;

    // 상하좌우
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    static void bfs(int startR, int startC) {
        Queue<int[]> queue = new ArrayDeque<>();

        queue.offer(new int[]{startR, startC});
        visited[startR][startC] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();

            int r = current[0];
            int c = current[1];

            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];

                // 범위를 벗어난 경우
                if (nr < 0 || nr >= n || nc < 0 || nc >= m) {
                    continue;
                }

                // 이동할 수 없는 칸
                if (board[nr][nc] == 0) {
                    continue;
                }

                // 이미 방문한 칸
                if (visited[nr][nc]) {
                    continue;
                }

                queue.offer(new int[]{nr, nc});
                visited[nr][nc] = true;
            }
        }
    }
}