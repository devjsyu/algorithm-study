## Key takeaways
- input이 single sequence라면, prefix/suffix를 우선적으로 고려한다.
- 선택에 따른 상태 전이: 
  - 현재 원소를 선택하는 경우와 선택하지 않는 경우를 나누어 최적해를 구할 수 있다.
  - SKIP? TAKE?
- 상태 의존성에 따른 공간 최적화 (optional):
  - 현재 상태가 이전 두 상태에만 의존한다면, $O(N)$ 공간을 $O(1)$으로 줄일 수 있다.

## SRTBOT framework for DP analysis
### Subproblem
X(i): nums[0, i) 범위에서 훔칠 수 있는 돈의 최댓값

### Recurrence
X(i) = max{X{i - 2} + nums[n - 1], X(i - 1)}

### Topological Order
for i : 2, ..., n

### Base Case
X(0) = 0  
X(1) = nums[0]

### Original Problem
X(n)

### Time Complexity
$O(N)$
