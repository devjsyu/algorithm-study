class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n + 1]; // 1-indexed
        dp[0] = true;

        Set<String> words = new HashSet<>(wordDict);

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (!dp[j]) {
                    continue;
                } 

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