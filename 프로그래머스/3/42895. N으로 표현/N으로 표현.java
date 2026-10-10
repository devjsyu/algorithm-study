import java.util.*;

class Solution {
    public int solution(int N, int number) {
        // dp[i]: N을 정확히 i번 사용해서 만들 수 있는 모든 숫자
        Set<Integer>[] dp = new HashSet[9];
        
        // Set<Integer>[] 자료구조 초기화 하기
        
        // dp[0]은 무시
        // 최솟값이 8보다 크면 -1을 return하므로 dp[8]까지만 필요
        for (int i = 1; i <= 8; i++) {
            dp[i] = new HashSet<>();
        }
        
        // Tabulation
        
        for (int i = 1; i <= 8; i++) {
            // Case 1
            // N, NN, NNN, ... 추가
            int repeated = 0;
            for (int k = 0; k < i; k++) {
                repeated = repeated * 10 + N;
            }
            dp[i].add(repeated);
            
            // Case 2
            // i번 사용을 두 그룹으로 나눈다.
            // j번 사용 + (i - j)번 사용
            // i가 3이라면, 1과2, 2와 1의 경우의 수로 나누기
            for (int j = 1; j < i; j++) {
                for (int a : dp[j]) {
                    for (int b : dp[i - j]) {
                        dp[i].add(a + b);
                        dp[i].add(a - b);
                        dp[i].add(a * b);
                        
                        if (b != 0) {
                            dp[i].add(a / b);
                        }
                    }
                }
            }
            
            // Tabulation early exit
            // i번 사용해서 number를 만들 수 있다면
            // 작은 i부터 계산했으므로 이것이 최소 사용 횟수다.
            if (dp[i].contains(number)) {
                return i;
            }            
        }
        
        return -1;
    }
}