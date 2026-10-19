/**
- n * m 2차원 배열로 모델링 하기
- TopDown이 아니라 BottomUp을 통해 최댓값 구하기
*/
class Solution {
    public int solution(int[][] triangle) {
        int n = triangle.length;
        
        int[][] dp = new int[n][n];
        
        // initialize base cases
        for (int i = 0; i < n; i++) {
            dp[n - 1][i] = triangle[n - 1][i];
        }
        
        // bottom up dp
        for (int i = n - 2; i >= 0; i--) {
            for (int j = i; j >= 0; j--) {
                dp[i][j] = Math.max(dp[i + 1][j], dp[i + 1][j + 1]) + triangle[i][j];
            }
        }
        
        return dp[0][0];
    }
}