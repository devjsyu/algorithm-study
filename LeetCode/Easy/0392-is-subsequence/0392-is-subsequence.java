/**
Suffix DP

State Definition
X(i, j): t[j:] 문자열에 대해 s[i:]가 subsequence인지 여부 

Transition
X(i, j) = X(i + 1, j + 1), if (s[i] = t[j])
        = X(i, j + 1), otherwise

Base Case
X(n, m) = true

Original Problem
X(0, 0)
 */
class Solution {
    public boolean isSubsequence(String s, String t) {
        if (s.isEmpty()) {
            return true;
        }
        
        int n = s.length();
        int m = t.length();

        boolean[][] dp = new boolean[n + 1][m + 1];
        dp[n][m] = true;
        for (int j = 0; j < m; j++) {
            dp[n][j] = true;
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                if (s.charAt(i) == t.charAt(j)) {
                    dp[i][j] = dp[i + 1][j + 1]; // dependent on the previous state
                } else {
                    dp[i][j] = dp[i][j + 1]; // narrowing the scope of searching
                }
            }
        }

        return dp[0][0];
    }
}