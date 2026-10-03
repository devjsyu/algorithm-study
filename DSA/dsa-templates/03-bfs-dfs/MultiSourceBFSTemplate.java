import java.util.*;

/**
 * Multi-Source BFS:
 *  모든 source와의 거리 중 최솟값을 한 번의 BFS로 계산하는 방법
 *  모든 source를 먼저 queue에 넣음으로써, 어느 source에서 출발했는지는 중요하지 않고, 가장 가까운 source까지의 거리가 자연스럽게 계산됨
 */
public class MultiSourceBFSTemplate {

    private static final int[] DR = {-1, 1, 0, 0};
    private static final int[] DC = {0, 0, -1, 1};

    record Cell(int row, int col) {}

    public static int[][] multiSourceBfs(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        Queue<Cell> queue = new ArrayDeque<>();

        int[][] dist = new int[rows][cols];
        for (int[] row : dist) {
            Arrays.fill(row, -1);
        }

        // 1. Add ALL sources before BFS starts
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (isSource(grid, r, c)) {
                    dist[r][c] = 0;
                    queue.offer(new Cell(r, c));
                }
            }
        }

        // 2. Run one BFS from all sources simultaneously
        while (!queue.isEmpty()) {
            Cell current = queue.poll();

            for (int d = 0; d < 4; d++) {
                int nc = current.row() + DR[d];
                int nc = current.col() + DC[d];

                if (nr < 0 || nr >= rows || nc < 0 || nc >= cols) {
                    continue;
                }
                if (!canVisit(grid, nr, nc)) {
                    continue;
                }

                if (dist[nr][nc] != -1) {
                    continue;
                }

                dist[nr][nc] = dist[current.row()][current.col()] + 1;

                queue.offer(new Cell(nr, nc));
            }
        }

        return dist;
    }

    private static boolean isSource(int[][] grid, int r, int c) {
        // Change according to the problem
        return grid[r][c] == 1;
    }

    private static boolean canVisit(int[][] grid, int r, int c) {
        // Change according to the problem
        return true;
    }
}