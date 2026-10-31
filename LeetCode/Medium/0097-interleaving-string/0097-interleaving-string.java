/**
s3 기준 n번째 문자는 s1 아니면 s2
Brute Force: O(2^N)
 */
class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int n = s1.length();
        int m = s2.length();

        // early exit
        if (n + m != s3.length()) {
            return false;
        }

        // dp[i][j]:
        // s1의 처음 i개 문자와 s2의 처음 j개 문자로
        // s3의 처음 i + j개 문자를 만들 수 있는가?
        boolean[][] dp = new boolean[n + 1][m + 1];

        // Base Case
        dp[0][0] = true;

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {

                // Case 1: s1에서 마지막 문자를 가져옴
                if (i > 0
                    && dp[i - 1][j]
                    && s1.charAt(i - 1) == s3.charAt(i + j - 1)) {
                    dp[i][j] = true;
                }

                // Case 2: s2에서 마지막 문자를 가져옴
                if (j > 0
                    && dp[i][j - 1]
                    && s2.charAt(j - 1) == s3.charAt(i + j - 1)) {
                    dp[i][j] = true;
                }
            }
        }

        return dp[n][m];
    }
}