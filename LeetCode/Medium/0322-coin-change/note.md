### analysis
#### 1. Why not Greedy?
- Greedy Approach는 일반적인 Coin Change 문제에서 최적해를 보장하지 않는다.
- 가장 큰 동전을 우선 선택하는 Local Optimal Choice가 최소 동전 개수라는 Global Optimum으로 이어진다는 보장이 없기 때문이다.
- 반레: coins = [1, 3, 4], amount = 6
  - Greedy: 4 + 1 + 1 => 3개
  - Optimal: 3 + 3 => 2개
- 단, 특정 동전 체계에서는 Greedy가 최적해를 보장할 수 있다.

#### 2. DP State Definition => Recurrence
- DP 상태를 정의할 때 문제의 요구사항을 그대로 반영하는 것부터 시도하자.
  - dp[i]: 금액 i를 만드는 최소 동전 개수
- 점화식을 찾기 어렵다면 **마지막 선택(Last Choice)**를 생각해보자.
  - 마지막 동전이 coin이라면 나머지 금액은 i - coin이다.
  - 후보 답은 dp[i - coin] + 1이다.
  - 가능한 모든 동전에 대해 후보 답의 최솟값을 선택한다. (`for-loop` + `Math.min`)
- Recurrence: 
  - dp[i] = min(dp[i - coin] + 1) for all valid coin
- Base Case:
  - dp[0] = 0

#### 3. DP Recurrence Patterns
- DP 점화식이 항상 Fibonacci처럼 고정된 두 상태를 참조하는 것이 아니다.
- 여러 이전 상태에서 후보 답을 생성하고, 문제의 목표에 따라 결합하거나 선택할 수 있다.
  - Fibonacci: 이전 두 상태의 합
  - Coin Change: 가능한 모든 이전 상태의 후보 중 최솟값
- `for-loop`과 `Math.min()`은 이번 점화식을 구현하는 수단이다.

#### 4. INF and Integer Overflow
- INF = amount + 1은 최소 동전 개수의 유효한 상한을 초과하는 안전한 **sentinel**이다.
- Integer.MAX_VALUE를 INF로 사용하면 INF + 1에서 integer overflow가 발생할 수 있다.
- DP에서 INF를 선택할 때는 유효한 답의 범위와 점화식의 연산을 함께 고려하자.

#### 5. Complexity
- Time: $O(amount \times coins.length)$
- Space: $O(amount)$

### my code
```java
/**
dp[i]: 주어진 배열 coins 원소 조합으로 i를 만들 수 있는 최솟값
불가능? dp[i] = 0
미결정? dp[i] = INF (integer overflow 될 수 있으니 Integer.MAX_VALUE 대신 amount + 1)
for (int coin : coins) {
    dp[i] = min(dp[i], dp[i - coin] + 1)
}
 */
import java.util.*;

class Solution {
    public int coinChange(int[] coins, int amount) {
        final int INF = amount + 1;

        int[] dp = new int[amount + 1];
        Arrays.fill(dp, INF);
        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (coin > i) continue;

                dp[i] = Math.min(
                    dp[i],
                    dp[i - coin] + 1
                );
            }
        }

        return dp[amount] == INF ? -1 : dp[amount];
    }
}
```