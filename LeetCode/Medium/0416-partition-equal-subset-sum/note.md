# 2D DP
- sequence S:   nums            → suffix nums[i:]
- target T:     sum(nums) / 2   → t for [0, T]

### SRTBOT framework for DP analysis
#### Subproblem
- X(i, t):
  - nums[i:n] 범위에서 일부 원소를 선택하여 합계 t를 만들 수 있는지 여부
  - nums[i]는 선택하거나 선택하지 않을 수 있다.

#### Recurrence
- X(i, t) = OR{X(i + 1, t), X(i + 1, t - nums[i])}
- constraint:
  - 두 번째 항은 (t - nums[i]) >= 0일 때만 유효
- possible decision for each case:
  - SKIP: nums[i]를 선택하지 않음
  - TAKE: nums[i]를 선택함

#### Topological Order
- for i : n - 1, ..., 0
  - for t : 0, ..., T

#### Base Case
- X(n, 0) = true
- X(n, t) = false, for t > 0

#### Original Problem
- X(0, T)
- early exit: sum(nums)가 홀수이면 false

#### Time Complexity
- $O(N * T)$

#### Space Complexity
- $O(N * T)$
  - 1D DP로 $O(T)$까지 최적화 가능

### Implementation
- `boolean[][] dp = new boolean[n + 1][T + 1]`
- dp[i][t] corresponds to X(i, t)
- [0, T] 범위에서 순회
- Prefix Sum은 필요하지 않음 (필요하다고 잘못 이해하였음)

### Key takeaway
> 0/1 Knapsack의 DP 상태는 '어떤 원소를 선택했는지'를 전부 기억할 필요가 없다
> 대신 다음 두 정보만 기억하면 된다.
> 1. _어떤 원소부터 선택할 수 있는가?_   → i
> 2. _앞으로 얼마를 더 만들어야 하는가?_ → t  

→ DP의 아름다움이라고 할 수 있다. Naive approach로 한다면, $O(2^N)$이 필요한데, $O(N * T)$로 대폭 줄일 수 있게 되었다.
  
- T/F를 묻는 Decision Problem은 점화식의 형태가 OR, AND이다.
- 최댓값, 최솟값을 묻는 Optimization Problem은 점화식의 형태가 max, min이다.

----


# 1D DP
### SRTBOT framework for 1D DP
#### Subproblem
- dp[t]:
  - 지금까지 처리한 원소들로 합계 t를 만들 수 있는지 여부

#### Recurrence
- dp[t] = dp[t] OR dp[t - num]
- SKIP: dp[t]
- TAKE: dp[t - num]

#### Topological Order
- for num : nums
  - for t : T, ..., num
- t는 반드시 역순으로 순회
  - 동일 원소의 중복 사용 방지 목적

#### Base Case
- dp[0] = true
- dp[t] = false, for t > 0

#### Original Problem
- dp[T]

#### Time Complexity
- $O(N * T)$

#### Space Complexity
- $O(T)$

### Key takeaway
#### 1D DP Space Optimization
> DP의 한 차원이 이전 단계의 상태만 참조한다면, 해당 차원을 제거하고 반복문의 진행 상태로 암시적으로 관리할 수 있다. 
> 이때, 동일한 배열을 덮어쓰므로, 기존 상태를 잘못 참조하지 않도록 순회 방향에 주의해야 한다.
  
_DP 배열에서 차원을 제거하는 것은 DP 문제에서 그 차원의 개념을 제거하는 것이 아니다._
i는 여전히 알고리즘의 논리적 상태에 존재하며, 단지, 배열에 명시적으로 저장하지 않았을 뿐이다.