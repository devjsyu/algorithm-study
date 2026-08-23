### Analysis
- 이게 왜 `Greedy Algorithm`인가?
  - 단순 완전탐색보다 더 효율적으로 풀 수 있는 조건이 있기 때문이다.
  - 이 문제를 왜 `Greedy Algorithm`으로 풀어도 되는가?
    1. **Greedy Choice Property** : 앞 단계의 최적 선택이 이후 선택에 악영향을 주지 않는다.
    2. **Optimal Substructure** : 각 부분 문제의 locally optimal solution이 전체 문제의 globally optimal solution으로 이어진다.

- _"가장 작은 쿠키부터 가장 소박한 아이에게 줘버리면 아이들을 최대한 많이 만족시킬 수 있다."_

- **Time Complexity**: $O(N log N + M log M)$ (정렬이 결정적)

### How I solved
1. 탐욕 배열과 쿠키 사이즈 배열을 각각 오름차순으로 정렬한다.
2. 탐욕 인덱스와 쿠키 사이즈 인덱스를 포인터 변수로서 초기화한다.
3. 각 배열 길이까지 범위를 갖는 반복문을 만든다.
4. 다음 조건에 따라 포인터 변수를 관리한다 : _"현재 내가 가진 가장 작은 쿠키로 가장 소박한 아이의 탐욕을 만족시킬 수 있는가?"_
5. 만족시킨 경우를 집계하여 반환한다.

### Key Takeaway
- `Two Pointer`는 $O(N * M)$ 완전탐색을 $O(N + M)$ 순회로 최적화 할 수 있다.
- `Greedy Algorithm`로 문제를 풀 때 정렬을 이용하는 것이 일반적이다. 현재 단계에서 가장 이득이 되는 결정이 무엇인지 알아야 하기 때문이다.