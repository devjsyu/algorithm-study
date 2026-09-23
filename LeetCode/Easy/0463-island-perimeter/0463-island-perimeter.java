class Solution {
    public int islandPerimeter(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        int[] startPosition = findStartPosition(grid, rows, cols);

        return bfs(grid, rows, cols, startPosition);
    }

    private int[] findStartPosition(int[][] grid, int rows, int cols) {
        // 최초로 grid[i][j] == 1인 지점 찾아서 BFS 시작하기
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    return new int[]{i, j};
                } 
            }
        }
        return null;
    }

    // 상하좌우
    private static final int[] dr = {-1, 1, 0, 0};
    private static final int[] dc = {0, 0, -1, 1};

    private int bfs(int[][] grid, int rows, int cols, int[] coordinates) {
        int count = 0;

        Queue<int[]> queue = new ArrayDeque<>();

        boolean[][] visited = new boolean[rows][cols];

        int row = coordinates[0];
        int col = coordinates[1];

        queue.offer(coordinates);
        visited[row][col] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();

            for (int d = 0; d < 4; d++) {
                int nr = current[0] + dr[d];
                int nc = current[1] + dc[d];

                if (nr < 0 || nr >= rows || nc < 0 || nc >= cols) {
                    count++; // 외곽과 맞닿으면 노란선 조건 만족
                    continue;
                }

                if (visited[nr][nc]) {
                    continue;
                }

                if (grid[nr][nc] == 0) {
                    count++; // 0과 맞닿으면 노란선 조건 만족
                    continue;
                }

                // from now on, this is quaranteed to be 
                // on-grid, not visited, tile
                queue.offer(new int[]{nr, nc});
                visited[nr][nc] = true;
            } 
        }

        return count;
    }
}