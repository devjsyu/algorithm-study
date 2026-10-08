/**
- 갈 수 있는 방향이 아래와 오른쪽 뿐이고, 그래프가 그리드 형태이기 때문에 항상 최단 거리일 것이다.
- 단지 다른 것은 '하'와 '우'의 순열일 것이다.
- 격자의 크기 m, n이 최대 100까지이기 때문에 물웅덩이가 없다면, '하', '우'로 이루어진 순열은 2^100개가 나올 것이다.
- 경로 개수: 곱연산
- 물웅덩이의 우측 상단 또는 좌측하단이라면 물웅덩이 간섭 없이 갈 수 있다.

1. State Definition

2. Transition

3. Base Case
*/
class Solution {
    private static final int MOD = 1_000_000_007;
    
    public int solution(int m, int n, int[][] puddles) {
        // dp[r][c] = (r, c)에 도달하는 경로의 수
        int[][] dp = new int[n + 1][m + 1];
        
        // 물엉덩이는 -1로 표시
        for (int[] puddle : puddles) {
            int col = puddle[0];
            int row = puddle[1];
            dp[row][col] = -1;
        }
        
        // 시작점까지 도달하는 방법은 1가지
        dp[1][1] = 1;
        
        for (int r = 1; r <= n; r++) {
            for (int c = 1; c <= m; c++) {
                // 물웅덩이는 이동 불가능
                if (dp[r][c] == -1) {
                    continue;
                }
                
                // 위쪽에서 오는 경로
                if (r > 1 && dp[r - 1][c] != -1) {
                    dp[r][c] = (dp[r][c] + dp[r - 1][c]) % MOD;
                }
                
                // 왼쪽에서 오는 경로
                if (c > 1 && dp[r][c - 1] != -1) {
                    dp[r][c] = (dp[r][c] + dp[r][c - 1]) % MOD;
                }
            }
        }
        
        return dp[n][m];
    }
}