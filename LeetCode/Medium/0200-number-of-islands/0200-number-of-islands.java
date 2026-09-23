class Solution {
    public int numIslands(char[][] grid) {
        this.grid = grid;
        this.rows = grid.length;
        this.cols = grid[0].length;
        this.visited = new boolean[rows][cols];
        
        int count = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    bfs(i, j);
                    count++;
                }
            }
        }

        return count;
    }

    // 상하좌우
    private static final int[] dr = {-1, 1, 0, 0};
    private static final int[] dc = {0, 0, -1, 1};

    private char[][] grid;
    private int rows;
    private int cols;
    private boolean[][] visited; 

    private void bfs(int row, int col) {
        Queue<int[]> queue = new ArrayDeque<>();
        
        queue.offer(new int[]{row, col});
        visited[row][col] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();

            for (int d = 0; d < 4; d++) {
                int nr = current[0] + dr[d];
                int nc = current[1] + dc[d];

                if (nr < 0 || nr >= rows || nc < 0 || nc >= cols) {
                    continue;
                }

                if (visited[nr][nc]) {
                    continue;
                }

                if (grid[nr][nc] == '0') {
                    continue;
                }

                queue.offer(new int[]{nr, nc});
                visited[nr][nc] = true;
            }
        }
    }
}