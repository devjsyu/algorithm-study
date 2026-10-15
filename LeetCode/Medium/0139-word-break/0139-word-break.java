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
                // 이전 접두사를 분할할 수 없다면 건너뛰기
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