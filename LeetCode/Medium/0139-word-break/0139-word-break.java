/**
- Subproblem
    - dp[i] = s[0, i)를 wordDict의 단어들로 완전히 분할할 수 있는지 여부
    - Prefix DP

- Recurrence
    - dp[i] = OR(dp[j] && wordDict.contains(s[j:i]))
    - 0 <= j < i
    - 하나 이상의 유효한 분할 위치 j가 존재하면 true

- Topological Order
    - for i : 1, ..., n
        - for j : 0, ..., i - 1

- Base Case
    - dp[0] = true

- Original Problem
    - dp[n]

- Time Complexity
    - O(N^3) for Java substring + HashSet implementation

- Key Insight
    - Prefix DP
    - 마지막 분할 위치 j를 기준으로 문제를 분할(segmentation)한다.
    - 유효한 prefix dp[j] 뒤에 사전의 단어를 붙일 수 있다면 dp[i] = true
 */
import java.util.*;

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();

        Set<String> words = new HashSet<>(wordDict);

        // dp[i]: s[0, i)를 분할할 수 있는지 여부
        boolean[] dp = new boolean[n + 1];

        // 빈 문자열은 분할 가능한 시작 상태
        dp[0] = true;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {

                // 이전 prefix를 분할할 수 없다면 건너뛰기
                if (!dp[j]) {
                    continue;
                }

                // 마지막 단어가 사전에 존재하는지 확인
                String word = s.substring(j, i);

                if (words.contains(word)) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[n];
    }
}