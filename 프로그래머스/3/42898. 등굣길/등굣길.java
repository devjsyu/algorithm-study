/**
- Subproblem
    - dp[i][j]: 좌표 i, j까지 가는 경우의 수
    
- Relate
    - dp[i][j] = dp[i - 1][j] + dp[i][j - 1]
    
- Topological Order
    - for 0, ..., n - 1

- Base Case
    - dp[0][0] = 1
    
- Original Problem
    - dp[|i| - 1][|j| - 1]
    
- Time Complexity
    - O(N^2)
*/
class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int rows = n;
        int cols = m;
        int[][] dp = new int[rows][cols];
        dp[0][0] = 1;
        
        for (int[] puddle : puddles) {
            int row = puddle[1] - 1;
            int col = puddle[0] - 1;
            
            dp[row][col] = -1;
        }
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (dp[i][j] == -1) {
                    dp[i][j] = 0;
                    continue;
                }
                
                if (i - 1 >= 0) {
                    dp[i][j] = (dp[i][j] + dp[i - 1][j]) % MOD;
                }
                
                if (j - 1 >= 0) {
                    dp[i][j] = (dp[i][j] + dp[i][j - 1]) % MOD;
                }                
            }
        }
        
        return dp[rows - 1][cols - 1];
    }
    
    private static final int MOD = 1_000_000_007;
}