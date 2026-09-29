### Monotonic Stack의 의의
- 오른쪽에서 처음으로 더 작은 원소를 찾는다면?
  - $O(N^2)$ Brute-force 비교 연산을 $O(N)$으로 바꾸는 마법
- Brute-force: 각 캐비넷에 대해 해당 캐비넷 오른쪽 방향 모든 캐비넷을 다 열어보기
  - _맨 마지막 캐비넷을 자주 열린다!_
- Monotonic Stack: 
  - 아직 조건 만족 여부가 정해지지 않은 원소를 일단 stack에 넣기
  - 새 원소에 대해, while 반복문으로 stack 속 원소가 조건 만족하는지 여부 검사하기
  - 새 원소 역시 stack에 넣기
  - 각 원소마다 최대 push 1번, pop 1번만 수행