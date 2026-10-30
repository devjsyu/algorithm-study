/**
Subproblem
X(i): 주어진 문자열 s의 [1, i) 범위 substring 문자열이 wordDict 집합에 포함되었는지 여부

Recurrence
X(i) = X(j) && [j, i) 문자열이 wordDict 집합에 포함되었는지 여부

Topological Order
for i : 1, ..., n
for j : 0, ..., n - 1

Base Case
X(0) = true

Original Problem
X(n)
 */
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();

        boolean[] dp = new boolean[n + 1]; // 1-indexed
        dp[0] = true;

        Set<String> set = new HashSet<>(wordDict);

        for (int i = 1; i <= n; i++) {
            for (String word : wordDict) {
                int length = word.length();

                if (i - length < 0) {
                    continue;
                }

                dp[i] = dp[i - length] && set.contains(s.substring(i - length, i));

                if (dp[i]) {
                    break;
                }
            }
        }

        return dp[n];
    }
}