# analysis
### Pattern
**_Opposite Direction Two Pointers_**
- 주어진 배열은 오름차순으로 정렬되어 있다.
- 절댓값이 가장 큰 원소는 반드시 배열의 양 끝 중 하나에 존재한다.
- 양 끝 원소의 절댓값을 비교하여 더 큰 쪽의 제곱을 결과 배열의 끝부터 저장한다.
- 선택한 쪽의 포인터만 안쪽으로 이동한다.  

### Complexity
- Time: $O(N)$
- Space: $O(N)$