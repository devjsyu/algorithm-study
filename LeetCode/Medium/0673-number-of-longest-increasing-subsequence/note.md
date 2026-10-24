### SRTBOT framework for DP analysis
#### Subproblems
- L(i) = prefix subset nums[:i] 범위에서 nums[i]로 끝나는 LIS 길이
- C(i) = prefix subset nums[:i] 범위에서 nums[i]로 끝나는 LIS 개수

#### Relate
- L(i) = 1 + max{L(j) | 0 <= j < i} (nums[j] < nums[i])
- C(i) = sum{C(j) | 0 <= j < i, max{L(j) + 1}를 만족하는 모든 j} (nums[j] < nums[i])

#### Topological Order
- for i : 0, ..., n - 1
  - for j : 0, ..., i - 1

#### Base Case
- L(0) = 1
- C(0) = 1

#### Original Problem
- sum{C(i) | maxLength == L(i)를 만족하는 모든 i}

#### Time Complexity
- O(N^2)