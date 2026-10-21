import java.util.*;

class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int cols = m;
        int rows = n; 
        
        int[][] grid = new int[rows][cols];
        grid[0][0] = 1;
        
        for (int[] puddle : puddles) {
            int col = puddle[0] - 1;
            int row = puddle[1] - 1;
            grid[row][col] = -1;
            
        }
        
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (grid[row][col] == -1) {
                    grid[row][col] = 0;
                    continue;
                } 
                
                if (row > 0) {
                    grid[row][col] += grid[row - 1][col];
                }

                if (col > 0) {
                    grid[row][col] += grid[row][col - 1];
                }
                
                grid[row][col] %= PRIME;
            }
        }

        return grid[rows - 1][cols - 1];
    }
    
    private static final int PRIME = 1_000_000_007;
}