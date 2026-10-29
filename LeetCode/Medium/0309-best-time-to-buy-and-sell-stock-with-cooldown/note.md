## SOLVE framework analysis
### Specify
_What am I solving?_
- 매일 매수, 매도, 휴식 중 가능한 행동을 선택하여 최대 이익을 구한다.
- 동시에 최대 1주만 보유할 수 있다.
- 매도한 다음 날에는 매수할 수 없다. (Cooldown)

### Outline
_What is the simplest solution?_
- Brute Force: 가능한 모든 행동 시퀀스를 재귀적으로 탐색한다.
- Time Complexity: $O(3^N)$ upper bound

### Locate
_Where is the bottleneck?_
- Brute Force에서는 동일한 날짜와 거래 상태에서 시작하는 부분문제를 반복 계산한다.
- DP를 사용하여 중복 부분문제(Overlapping subproblem)의 최적값을 저장하고 재사용한다. 

### Value
_What information do I actually need?_
- 현재 상태에 따라 다음 날 가능한 행동(그리고 그에 따른 상태)이 달라진다.
- `State Machine DP`를 고려한다.
- 3가지 상태(State)를 정의한다.
  - HOLD: 주식 보유
  - SOLD: 오늘 매도
  - REST: 주식을 보유하지도 않고, 오늘 매도하지도 않음
- 1차원 DP 배열 3개를 사용한다.

### Evaluate
_Does my solution always work?_
- input size: N < $5 * 10^3$
- $O(N^2)$ 시간복잡도 통과 경계선 / $O(N)$ 시간복잡도 통과 가능
- possible edge cases:
  - base case: 첫날 매도는 현실적으로 불가능하기 때문에 -INF로 초기화 필요
  - 마지막 날: 주식을 보유하지 않은 상태의 최대 이익 반환

## SRTBOT framework for DP analysis
### Subproblem
- rest[i]: i번째날 **휴식**하는 선택(보유 X 매도 X)을 했을 때의 이익 최댓값
- hold[i]: i번째날 **보유**하는 선택을 했을 때의 이익 최댓값
- sold[i]: i번째날 **매도**하는 선택을 했을 때의 이익 최댓값

### Recurrence
- rest[i] = Math.max(rest[i - 1], sold[i - 1])
- hold[i] = Math.max(hold[i - 1], rest[i - 1] - prices[i])
- sold[i] = hold[i - 1] + prices[i]

### Topological Order
- for i : 1, ..., n - 1

### Base Case
- hold[0] = -prices[0]
- sold[0] = -INF
- rest[0] = 0

### Original Problem
- max{sold[n - 1], rest[n - 1]}

### Time Complexity
- $O(N)$

## Pattern
- `State Machine DP`

### What is it?
- 문제를 유한한 상태(State)와 상태 간 전이(Transition)로 모델링하여 최적값이나 경우의 수를 계산하는 DP 패턴
- 현재 상태에 따라 가능한 다음 행동이나 전이가 결정된다.
- 상태 전이에는 제약조건이 존재할 수 있다.

### How to recognize this pattern
- Do I need multiple distinct states?
  - 같은 진행 위치에서 서로 다른 의미의 상태를 2개 이상 구분해야 하는가?
- Does the current state restrict what I can do next?
  - 현재 상태에 따라 허용되는 행동이나 다음 상태로의 전이가 달라지는가?

## Real-world Analogy
### Legal Career Optimization

Problem:
- 사법시험 합격자가 N년 동안 전직 제약을 지키면서 얻을 수 있는 최대 누적 소득을 구한다.
- 직업별 연봉은 연도에 따라 달라질 수 있다.
- 전직은 매년 한 번만 가능하다고 가정한다.

States:
- PROSECUTOR: 검사
- JUDGE: 판사
- LAW_FIRM: 로펌 변호사
- PUBLIC_DEFENDER: 국선 변호사
- RETIRED: 은퇴자

Actions:
- STAY: 현재 직업 유지
- SWITCH: 다른 직업으로 전직
- RETIRE: 은퇴

Transition Constraints:
- 검사와 판사는 변호사 또는 은퇴자로 전환 가능
- 변호사에서 검사나 판사로 전환 불가능
- 은퇴 후 다른 직업으로 복귀 불가능
- 현재 직업 유지 가능 (은퇴 상태 포함)

DP State:
- dp[year][career]
- 해당 연도에 특정 직업을 가진 상태에서의 최대 누적 소득

Key Insight:
- 현재 직업에 따라 다음 연도에 선택할 수 있는 직업이 달라진다.
- 따라서 직업별 상태와 허용되는 전이를 모델링한다.
- 각 상태에 도달하는 최대 누적 소득을 DP로 계산한다.