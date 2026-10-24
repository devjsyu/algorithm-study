### SRTBOT framework for DP analysis
#### Subproblems
- L(i) = nums[0..i]에서 nums[i]로 끝나는 LIS의 최대 길이
- C(i) = nums[0..i]에서 nums[i]로 끝나는 LIS의 개수

#### Relate
- L(i) = max{1, 1 + L(j) | 0 <= j < i, nums[j] < nums[i]}
- C(i) = sum{C(j) | 0 <= j < i, nums[j] < nums[i], L(j) + 1 == L(i)}

#### Topological Order
- for i : 0, ..., n - 1
  - for j : 0, ..., i - 1

#### Base Case
- L(i) = 1 for all i
- C(i) = 1 for all i

#### Original Problem
- sum{C(i) | maxLength == L(i)를 만족하는 모든 i}
    - maxLength = max{L(i) | 0 <= i < n}
#### Time Complexity
- O(N^2)

----

### key takeaway
- 문제에서 요구하는 것: 
  - LIS 최대 길이의 개수 
  - → LIS 길이, LIS 개수 각각 2개의 DP 배열로 상태 관리
- 처리 로직
  - 더 좋은 최적값 발견 → 최적값과 경우의 수를 교체
  - 동일한 최적값 발견 → 경우의 수를 누적

### key question
**_"왜 C(i) += 1이 아니라 C(i) += C(j)인가?"_**
> 이전 상태에서 현재 상태로 연결하는 방법이 하나여도, 이전 상태에 도달하는 방법이 여러 개라면 그 모든 방법이 새로운 경우의 수가 된다.
```text
서울에서 부산까지 여행하는데, 중간에 대전을 거쳐야 한다고 가정하자.
이때, 서울에서 대전까지 가는 경로가 3개 있다고 하자.
만약, 대전에서 부산까지 가는 새 경로 1개 추가되었다면?
서울에서 부산까지 가는 경로는 1개가 추가된 게 아니라, 3개가 추가된 것이다.
왜냐하면 기존의 서울-대전 경로 3개 모두 새 대전-부산 경로에 연결할 수 있기 때문이다.

이것이 바로 C(j)를 더하는 이유!
```