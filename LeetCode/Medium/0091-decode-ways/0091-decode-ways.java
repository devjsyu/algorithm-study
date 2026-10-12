/**
1. State Definition
dp[i]: 길이 i 문자열에서 나올 수 있는 경우의 수

2. Transition
자릿수 조합
dp[i] = dp[i - 1] + dp[i - 2]

자릿수 조합은 충족하나 digit의 허용범위 밖인 경우 필터링
- 1의 자리일 경우 1~9만 허용
- 10의 자리일 경우 1~2만 허용

3. Base Case
dp[0] = 1 // 아무것도 선택하지 않은 유효한 방법이 1개 존재
dp[1] = 1
dp[2] = 2
 */
class Solution {
    public int numDecodings(String s) {
        int n = s.length();

        // dp[i]: 앞에서 i개 문자를 해석하는 방법의 수
        int[] dp = new int[n + 1]; // 1-index

        // Base Cases
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;

        for (int i = 2; i <= n; i++) {
            
            // Case 1: 마지막 1자리를 해석
            int oneDigit = s.charAt(i - 1) - '0';

            if (oneDigit >= 1 && oneDigit <= 9) {
                dp[i] += dp[i - 1];                
            }

            // Case 2: 마지막 2자리를 함께 해석
            int twoDigits = 
                (s.charAt(i - 2) - '0') * 10 
                + (s.charAt(i - 1) - '0');
            
            if (twoDigits >= 10 && twoDigits <= 26) {
                dp[i] += dp[i - 2];
            }
            
        }

        return dp[n];
    }
}