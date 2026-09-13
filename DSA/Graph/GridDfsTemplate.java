import java.util.*;

class GridDfsTemplate {
    static int n, m;
    static int[][] board;
    static boolean[][] visited;

    // 상, 하, 좌, 우
    static int[] dr = {-1, 1, 0, 0}; // dr for delta row
    static int[] dc = {0, 0, -1, 1}; // dc for delta column

    static void dfs(int r, int c) {
        visited[r][c] = true;

        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d]; // nr for next row
            int nc = c + dc[d]; // nc for next column

            // 범위를 벗어난 경우
            if (nr < 0 || nr >= n || nc < 0 || nc >= m) {
                continue;
            }

            // 방문할 수 없는 칸
            if (board[nr][nc] == 0) {
                continue;
            }

            // 이미 방문한 칸
            if (visited[nr][nc]) {
                continue;
            }

            dfs(nr, nc);
        }
    }
}