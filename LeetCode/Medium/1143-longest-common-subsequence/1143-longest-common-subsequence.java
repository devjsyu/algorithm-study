/**
State Definition
dp[i, j]: text1[i:n)와 text2[j:m) 문자열 간의 LCS 길이

Transition
dp[i, j] = 
    if (text1[i] == text2[j]) :
        yes => dp[i + 1, j + 1] + 1
        no  => max{dp[i + 1, j], dp[i, j + 1]}

Base Case
dp[n, j] = 0
dp[i, m] = 0
 */
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();

        int[][] dp = new int[n + 1][m + 1];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    dp[i][j] = dp[i + 1][j + 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j + 1], dp[i + 1][j]);
                }
            }
        }

        return dp[0][0];
    }
}