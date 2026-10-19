/**
1. State Definition
주어진 문자열 s에 대해서 dp[i]는 인덱스 i까지 범위에 대한 복호화 가능 개수이다.

2. Transition
dp[i] = 각 조건에 만족할 경우 누적 집계: dp[i - 2], dp[i - 1]

3. Base Case
dp[0] = 0보다 클 경우 1, 아닐 경우 0 
dp[1] = 0보다 클 경우 dp[0] 1과 십의 자리 경우 1 합산, 아닐 경우 0
 */
class Solution {
    public int numDecodings(String s) {
        int n = s.length();

        if (n < 2) {
            return s.charAt(0) - '0' > 0 ? 1 : 0; 
        }

        int[] dp = new int[n];

        if (s.charAt(0) == '0') {
            dp[0] = 0;
            dp[1] = 0;
        } else {
            dp[0] = 1;
            dp[1] += s.charAt(1) != '0' ? 1 : 0;
            dp[1] += Integer.parseInt(s.substring(0, 2)) <= 26 ? 1 : 0;
        }

        for (int i = 2; i < n; i++) {
            if (s.charAt(i) != '0') {
                dp[i] += dp[i - 1];            
            }

            if (s.charAt(i - 1) != '0' && Integer.parseInt(s.substring(i - 1, i + 1)) <= 26) {
                dp[i] += dp[i - 2];
            }
        }

        return dp[n - 1];
    }
}