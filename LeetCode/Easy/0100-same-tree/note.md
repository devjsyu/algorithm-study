- 그래프를 순회하는 DFS 로직을 이 문제에 맞춰 구현하기
- 기본 틀 (base condition for ending / recursive part for next)
- 이 문제 특화 조건 : 
  1. 두 요소를 비교해야 하기 때문에 재귀함수 메서드가 2개여야 한다. 
  2. 즉시 false 반환을 위해 재귀함수 반환형은 boolean이여야 한다.
  3. base condition을 모두 만족해야 비로소 true이다.
  4. recursive part를 모두 만족해야 비로소 true이다.
  5. mismatch case filtering을 통과하지 못하면 즉시 false이다.
     - 한쪽에만 값이 있는가?
     - 양쪽 모두 값이 있다면, 그 값이 서로 동일한가?