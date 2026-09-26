class Solution {
    public int islandPerimeter(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        
        // 시작점 찾기
        int[] start = findStartPoint(grid, rows, cols);

        return bfs(grid, rows, cols, start);
    }

    // 상하좌우
    private static final int[] dr = {-1, 1, 0, 0};
    private static final int[] dc = {0, 0, -1, 1};

    private int[] findStartPoint(int[][] grid, int rows, int cols) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    return new int[]{i, j};
                }
            }
        }

        return null;
    }

    private int bfs(int[][] grid, int rows, int cols, int[] start) {
        Queue<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[rows][cols];
        int count = 0;

        queue.offer(start);
        visited[start[0]][start[1]] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();

            for (int d = 0; d < 4; d++) {
                int nr = current[0] + dr[d];
                int nc = current[1] + dc[d];

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

                queue.offer(new int[]{nr, nc});
                visited[nr][nc] = true;
            }
        }

        return count;
    }
}