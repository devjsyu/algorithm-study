import java.util.*;

public class DP {
    public int tabulation(int n) {
        // 1. State Definition
        // dp[i] = i 상태에서의 답
        int[] dp = new int[n + 1];

        // 2. Base Case
        dp[0] = /* base value */;

        // 3. Transition
        // 현재 상태가 의존하는 상태들이 먼저 계산되도록 순서를 정한다.
        for (int i = 1; i <= n; i++) {

            // 가능한 이전 상태 / 선택을 이용해 현재 상태를 계산한다.
            // 예:
            // dp[i] = dp[i - 1] + ...;
            //
            // 또는
            // dp[i] = Math.max(
            //     dp[i - 1],
            //     dp[i - 2] + ...
            // );
        }

        // 4. Answer
        return dp[n];
    }

    private int[] memo;

    private int memoization(int n) {
        memo = new int[n + 1];

        // -1: 아직 계산하지 않은 상태
        Arrays.fill(memo, -1);

        return dp(n);
    }

    private int dp(int i) {
        // 1. Base Case
        if (i == 0) {
            return /* base value */;
        }

        // 2. Memoization
        // 이미 계산한 상태라면 다시 계산하지 않는다.
        if (memo[i] != -1) {
            return memo[i];
        }

        // 3. Transition
        // 더 작은 상태의 답으로 현재 상태의 답을 계산한다.
        int result = /* dp(...)를 이용한 계산 */;

        // 4. Store
        memo[i] = result;

        return result;
    }
}