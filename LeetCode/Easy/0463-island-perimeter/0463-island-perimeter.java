class Solution {
    public int islandPerimeter(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        int perimeter = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 0) {
                    continue;
                }            

                for (int d = 0; d < 4; d++) {
                    int nr = i + DR[d];
                    int nc = j + DC[d];

                    if (nr < 0 || nr >= rows ||
                        nc < 0 || nc >= cols || 
                        grid[nr][nc] == 0) {
                        perimeter++;
                    }
                }
            }
        }

        return perimeter;
    }

    private static final int[] DR = {-1, 1, 0, 0};
    private static final int[] DC = {0, 0, -1, 1};
}