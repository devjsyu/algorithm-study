/**
SRTBOT
- Subproblems:      
    - dp(i, j)은 A[i:]와 B[j:]의 LCS이다.

- Relate:
    - if (A[i] == B[j]): 1 + dp(i + 1, j + 1) 
    - else: max{dp(i, j + 1), dp(i + 1, j)}

- Topological Order:
    - for i: |A| , ..., 0 (decreasing)
    - for j: |B| , ..., 0 (decreasing)
    - A와 B의 input subset 기준이 suffix이기 때문에 역순으로 진행해야 의존하는 상태를 먼저 계산할 수 있다.

- Base Case
    - dp[|A|, j] = dp[i, 0]

- Original Problem
    - dp[0][0]

- Time Complexity
    - O(N^2)
 */
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int length1 = text1.length();
        int length2 = text2.length();

        int[][] dp = new int[length1 + 1][length2 + 1]; // 1-indexed
        // Base Case: dp[length1][j] = dp[i][length2] = 0

        for (int i = length1 - 1; i >= 0; i--) {
            for (int j = length2 - 1; j >= 0; j--) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    dp[i][j] = 1 + dp[i + 1][j + 1];
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j + 1]);
                }
            }
        }

        return dp[0][0];
    }
}