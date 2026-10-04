class Solution {
    public int islandPerimeter(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        Coord start = findStartPoint(grid, rows, cols);

        return bfs(grid, rows, cols, start);
    }

    private int bfs(int[][] grid, int rows, int cols, Coord start) {
        Queue<Coord> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[rows][cols];

        queue.offer(start);
        visited[start.row()][start.col()] = true;

        int count = 0;

        while (!queue.isEmpty()) {
            Coord current = queue.poll();

            for (int d = 0; d < 4; d++) {
                int nr = current.row() + DR[d];
                int nc = current.col() + DC[d];

                if (nr < 0 || nr >= rows || nc < 0 || nc >= cols) {
                    count++;
                    continue;
                }

                if (visited[nr][nc]) {
                    continue;
                }

                if (grid[nr][nc] == 0) {
                    count++;
                    continue;
                }

                queue.offer(new Coord(nr, nc));
                visited[nr][nc] = true;
            }
        }

        return count;
    }

    private static final int[] DR = {-1, 1, 0, 0};
    private static final int[] DC = {0, 0, -1, 1};

    public record Coord(int row, int col) {}

    private Coord findStartPoint(int[][] grid, int rows, int cols) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    return new Coord(i, j);
                }
            }
        }

        return null;
    }
}