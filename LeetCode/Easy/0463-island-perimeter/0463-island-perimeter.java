class Solution {
    public int islandPerimeter(int[][] grid) {
        Queue<int[]> queue = new ArrayDeque<>();
        this.grid = grid;

        int startRow = -1;
        int startCol = -1;

        Coordinates start = findStart();

        return bfs(start);
    }

    private Coordinates findStart() {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    return new Coordinates(i, j);
                }
            }
        }
        return null;
    }

    private int[][] grid;

    public record Coordinates(int row, int col) {}

    private int bfs(Coordinates start) {
        Queue<Coordinates> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[grid.length][grid[0].length];

        queue.offer(start);
        visited[start.row()][start.col()] = true;

        int count = 0;
        while (!queue.isEmpty()) {
            Coordinates current = queue.poll();

            for (int d = 0; d < 4; d++) {
                int nr = current.row() + dr[d];
                int nc = current.col() + dc[d];

                if (nr < 0 || nr >= grid.length || nc < 0 || nc >= grid[0].length) {
                    count++;
                    continue;
                }

                if (visited[nr][nc]) {
                    continue;
                }

                if (grid[nr][nc] == 0) {
                    count++;
                } else if (grid[nr][nc] == 1) {
                    queue.offer(new Coordinates(nr, nc));
                    visited[nr][nc] = true;
                } 
            }
        }

        return count;
    }

    // 상하좌우
    private static final int[] dr = {-1, 1, 0, 0};
    private static final int[] dc = {0, 0, -1, 1};
}