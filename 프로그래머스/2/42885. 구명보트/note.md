### How I analyzed
- Greedy Algorithm
- Two Pointers
- _무거운 사람부터 태우고 여유가 있다면 가벼운 사람까지 태우면 된다!_

### Why I struggled
- 가벼운 사람부터 태우고 무거운 사람을 태우려고 했다.
- leftIndex와 rightIndex 관리를 제대로 못 했다. 이 둘 간의 대소 관계가 역전되기도 하고, 갱신을 어떻게 해야 할 지 몰랐다.
- 반면, 무거운 사람부터 태운다는 힌트를 보는 순간, 논리가 순식간에 명료해졌다.

### How I solved
- 오름차순 정렬
- 왼쪽, 오른쪽 인덱스를 Two Pointer로서 사용
- 모든 사람이 탈출할 때까지 반복문 반복 후 누적 집계된 보트 사용 횟수 반환