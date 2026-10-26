/**
input: double sequence => product of suffix

- Subproblems
    - X(i, j): text1[i:]와 text2[j:]의 LCS 길이

- Recurrence
    - if (text1[i] == text2[j]) :
        - yes?  X(i, j) = X(i + 1, j + 1) + 1
        - no?   X(i, j) = max{X(i + 1, j), X(i, j + 1)}

- Topological Order
    - for i : n - 1, ..., 0
        - for j : m - 1, ..., 0

- Base Case
    - X(N, M) = 0

- Original Problem
    - X(0, 0)

- Time Complexity
    - O(N * M)
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