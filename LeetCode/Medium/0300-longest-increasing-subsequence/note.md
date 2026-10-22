## DP analysis framework
#### Input → Subproblem
- Input: Single sequence
- Subproblem: Suffix

#### Subproblem
- `dp[i]`: `nums[i]`에서 시작하는 LIS의 길이
- 반드시 `nums[i]`를 포함한다.

#### Relate (Recurrence)
- `dp[i] = max(dp[i], 1 + dp[j])`
- conditions:
  - `i < j < n`
  - `nums[i] < nums[j]`

#### Topological Order 
- for i = (n - 1) down to 0
    - for j = j + 1 to n - 1

#### Base Case
- `dp[i] = 1`
- `nums[i]` 하나만 선택하는 경우

#### Original Problem
- `max(dp[i]) for 0 <= i < n`

#### Complexity
- Time: $O(N^2)$
- Space: $O(N)$

## key insight
- `dp[i]`는 반드시 `nums[i]`를 포함해야 한다.
  - 원소를 skip할 수 있는 subsequence의 특성 때문에 필요한 제약
- `dp[i]`가 오른쪽 상태 `dp[j]`에 의존하므로 역순으로 계산한다.
- LIS의 시작 위치는 정해져 있지 않으므로 모든 `dp[i]`의 최댓값을 구한다.