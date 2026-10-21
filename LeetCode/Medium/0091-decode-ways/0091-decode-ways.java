/**
- 어떤 정보를 기억해야 다음 단계의 문제를 풀 수 있는가?
    - dp[i]: 주어진 문자열 s의 [0, i] 범위에 대해 복호화 할 수 있는 조합 경우의 수

- 이전 단계의 상태를 어떻게 조합해야 이번 단계 상태를 만들 수 있는가?
    - dp[i] = (dp[i - 2]와 2자릿수 조합) 경우의 수 + (dp[i - 1]와 1자릿수 조합) 경우의 수

- Base Case
    - dp[0] = 1
    - dp[1] = 1

- 주의점
    - 첫번째 자리가 0이 나오면 가능한 조합은 무조건 0
    - 1자릿수 허용 숫자 범위: 1~9
    - 2자릿수 허용 숫자 범위: 10~26
 */
class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        
        if (s.charAt(0) == '0') {
            return 0;
        }

        if (n < 2) {
            return 1;
        }
        
        int[] dp = new int[n + 1]; // 1-indexed

        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            // 1자릿수
            int oneDigit = s.charAt(i - 1) - '0';
            if (oneDigit > 0 && oneDigit <= 9) {
                dp[i] += dp[i - 1];
            }

            // 2자릿수
            int twoDigit = (s.charAt(i - 2) - '0') * 10 + s.charAt(i - 1) - '0';
            if (twoDigit >= 10 && twoDigit <= 26) {
                dp[i] += dp[i - 2];
            }
        }

        return dp[n];
    }
}