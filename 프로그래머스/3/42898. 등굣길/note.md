## review
### key insight
- Counting paths → Sum the number of ways from valid predecessors.
- Blocked cells → Set their number of ways to 0.
- DP traversal must respect dependency order.

### analysis framework for DP problem
- Subproblem
    - dp[i][j]: 시작점 (0, 0)에서 좌표 (i, j)까지 도달하는 유효한 경로의 수


- Relate
  - 물웅덩이일 경우?
    - yes => `dp[i][j] = 0`
    - no => `dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % 1_000_000_007`
  

- Topological Order
    - for 0, ..., rows - 1
      - for 0, ..., cols - 1
> dp[i][j]를 계산하려면 다음 두 상태가 먼저 계산되어 있어야 한다.
> - dp[i-1][j]
> - dp[i][j-1]  
>
> 행 우선 순회(Row-major Order)를 사용하면 두 상태가 모두 현재 좌표보다 먼저 계산된다.

- Base Case
    - dp[0][0] = 1
 > 시작점에서 시작점까지 도달하는 방법이 정확히 한 가지 있다는 의미다. 아무것도 하지 않는 경로를 하나로 세는 것이다. 

- Original Problem
    - dp[rows - 1][cols - 1]
  

- Time Complexity
    - O(rows * cols)