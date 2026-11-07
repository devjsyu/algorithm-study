### Suffix DP
```java
/**
 * Suffix DP
 *
 * State Definition
 * X(i, j): Whether s[i:] is a subsequence of t[j:].
 *
 * Transition
 * X(i, j) = X(i + 1, j + 1), if s[i] == t[j]
 *         = X(i, j + 1),     otherwise
 *
 * Topological Order
 * for i = n - 1, ..., 0
 *     for j = m - 1, ..., 0
 *
 * Base Case
 * X(n, j) = true,  for 0 <= j <= m
 * X(i, m) = false, for 0 <= i < n
 *
 * Original Problem
 * X(0, 0)
 *
 * Time Complexity: O(n * m)
 * Space Complexity: O(n * m)
 */
class Solution {
    public boolean isSubsequence(String s, String t) {
        int n = s.length();
        int m = t.length();

        boolean[][] dp = new boolean[n + 1][m + 1];

        // Base Case
        for (int j = 0; j <= m; j++) {
            dp[n][j] = true;
        }

        // Bottom-up DP
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                if (s.charAt(i) == t.charAt(j)) {
                    dp[i][j] = dp[i + 1][j + 1];
                } else {
                    dp[i][j] = dp[i][j + 1];
                }
            }
        }

        return dp[0][0];
    }
}
```

### Two Pointers
```java
/**
 * Why Two Pointers?
 *
 * - A naive approach may repeatedly scan parts of t,
 *   leading to O(n * m) time complexity.
 *
 * - A subsequence preserves the relative order of characters
 *   while allowing characters in t to be skipped.
 *
 * - Matching each character of s with the earliest available
 *   matching character in t is always safe.
 *
 * - Therefore, we can scan t from left to right
 *   without backtracking.
 *
 * Time Complexity: O(m)
 * Space Complexity: O(1)
 *
 * n = s.length()
 * m = t.length()
 */
class Solution {
    public boolean isSubsequence(String s, String t) {
        int n = s.length();
        int m = t.length();

        int targetIndex = 0;
        int searchIndex = 0;

        while (targetIndex < n && searchIndex < m) {
            if (s.charAt(targetIndex) == t.charAt(searchIndex)) {
                targetIndex++;
            }
            searchIndex++;
        }

        return targetIndex == n;
    }
}
```