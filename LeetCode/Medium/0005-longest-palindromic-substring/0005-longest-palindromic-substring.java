/**
 * 1. State Definition
 * dp[i][j]:
 * substring s[i..j]가 palindrome인지 여부
 * (양 끝 인덱스 포함)
 *
 * 2. Transition
 * dp[i][j] =
 *     s[i] == s[j]
 *     && (j - i <= 2 || dp[i + 1][j - 1])
 *
 * 3. Base Case
 * 길이 1: 항상 palindrome
 * 길이 2~3: 양 끝 문자가 같으면 palindrome
 *
 * 4. Iteration Order
 * dp[i][j]는 dp[i + 1][j - 1]에 의존한다.
 * 따라서 i를 역순으로 순회한다.
 *
 * 5. Complexity
 * Time: O(N^2)
 * Space: O(N^2)
 */
class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];

        int max = 1;
        int[] index = {0, 0};
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                dp[i][j] = s.charAt(i) == s.charAt(j) && ((j - i <= 2) || (dp[i + 1][j - 1]));

                if (dp[i][j] && max < j - i + 1) {
                    max = j - i + 1;
                    index = new int[]{i, j};
                }
            }
        }

        return s.substring(index[0], index[1] + 1);
    }
}