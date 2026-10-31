/**
Subproblem
X(i, j): 두 문자열 suffix 범위 i, j에 대한 LCS의 길이 (최댓값)

Recurrence
X(i, j) = text1[i] == text2[j] ? 
            X(i + 1, j + 1) + 1 :
            max{X(i + 1, j), X(i, j + 1)}

Topological Order
for i : n - 1, ..., 0
for j : m - 1, ..., 0

Base Case
X(n, j) = 0
X(i, m) = 0

Original Problem
X(0, 0)
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
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j + 1]);
                }
            }
        }

        return dp[0][0];
    }
}