## Pattern: Set-based DP
- 최솟값을 구하는 문제라고 해서 반드시 DP state까지 최솟값이라는 보장은 아니다.
- 어떤 숫자가 나중에 목표값을 만드는 데 도움이 될지 미리 알 수 없기 때문에, 최댓값이나 최솟값 하나만 저장하는 대신, 다음 상태를 계산하는 데 필요한 모든 결과를 집합으로 보존하는 것이 핵심이다.
- 가능한 숫자들의 집합을 DP state로 정의하고, 사용 횟수를 작은 순서부터 탐색함으로써 최솟값을 구한다.

## DP analysis framework

### Subproblem
X(i): N를 i개 사용해서 나타낼 수 있는 모든 숫자 집합 (단, 1 <= i <= 8)

### Recurrence
X(i) = union{{N을 i개 이어붙인 숫자}, union{X(j) 집합의 원소와 X(k) 집합의 원소 간의 사칙연산으로 나타낼 수 있는 모든 숫자 집합 | j + k = i, 1 <= j, k < i}}

### Topological Order
- for i : 1, ..., 8
    - for j : 1, ..., i - 1
        - for k = i - j

### Base Case
X(1) = {N}

### Original Problem
min{i | X(i)가 number를 포함, 1 <= i <= 8}  
단, 존재하지 않으면 -1