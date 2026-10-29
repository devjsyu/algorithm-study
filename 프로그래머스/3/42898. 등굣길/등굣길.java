/**
- State Definition
    - dp[row][col]: 해당 좌표까지 도달할 수 있는 경우의 수 개수

- Transition
    - dp[row][col] = sum{dp[row - 1][col], dp[row][col - 1] | 0 <= row - 1 < rows, 0 <= col - 1 < cols}
    
- Base Case
    - dp[0][0] = 1
    - puddles에 해당하는 좌표는 모두 0으로 초기화

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
            
            dp[row][col] = Integer.MIN_VALUE; // -INF
        }
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (dp[i][j] == Integer.MIN_VALUE) {
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