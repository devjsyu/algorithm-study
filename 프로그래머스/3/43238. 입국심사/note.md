### Analysis
**Binary Search**
- 최적화 문제를 결정 문제로 전환하고, 판별 결과의 단조성이 보장될 때, Parametric Search를 적용할 수 있다.
  - 최적화 문제 : 모든 사람 n명이 심사를 받는데 걸리는 시간의 최솟값을 구하시오
  - 결정 문제 : 모든 심사관이 총 시간 x 이하로 일했을 때, n명 이상의 인원을 심사할 수 있는가? (Yes/No)

- Parametric Search를 위한 구성 요소
  - x의 범위 (1초부터 '이론상 최대 심사 시간'까지)
  - Monotonicity : 주어진 시간 x가 커질수록 총 심사 가능 인원 f(x)는 단조 증가
    - 결정 조건 f(x) >= n 은 [False, ..., False, True, True, ...] 형태를 띤다.
  - Leftmost True 탐색 : n명 이상이면서 x의 최솟값 구하기
      - f(x) >= n (가능) -> `answer = x` 갱신 후 더 적은 시간 탐색 (right = middle - 1)
      - f(x) < n (불가능) -> 시간을 더 늘려 탐색 (left = middle + 1)

- 자료형 주의
  - 시간 범위 및 판별 함수 반환값이 int 범위를 초과하므로 long 연산 필수

### How I solved
1. 가장 느린 심사관의 심사 소요 시간 구하기
2. 이론상 심사 시간 최댓값 구하기 (가장 느린 심사관에게 모두 심사 받는 경우)
3. 이론상 심사 시간 최솟값 구하기 (가장 빠른 심사관에게 1명만 심사 받는 경우)
4. 판별 함수 정의 : 모든 심사관이 x 시간 일할 때, 심사할 수 있는 총 인원 수 반환
   - 각 심사관별 `x / time`을 합산하여 총 심사 인원 수 반환
5. while-loop을 통한 이분 탐색 수행
   - `middle = left + (right - left) / 2`로 오버플로우를 방지
6. 조건을 만족하는 middle을 answer로 갱신하면서 최솟값(Leftmost True) 도출

### Key Takeaway
- 단조성이 보장되는 결정 문제에서 '최솟값'을 구할 때는 조건을 만족하는 Leftmost True을 찾아 경계를 왼쪽으로 좁혀나간다
- 탐색 범위가 $2 \times 10^9$를 넘는 문제는 `left`, `right`, `middle` 및 누적합 연산에 `long` 타입 캐스팅을 철저히 적용해야 한다