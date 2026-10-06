### Why Prefix Sum?
특정 구간의 합을 반복적으로 구해야 한다면, 각 위치까지의 누적 합을 미리 계산해 둔다. 이후 두 누적 합의 차이를 이용하면 각 구간의 합을 $O(1)$에 구할 수 있어 반복적인 덧셈 연산을 피할 수 있다.

### key takeaway
- `prefix[i + 1] = prefix[i] + nums[i];`
- `prefix[i]`는 원본 배열의 `[0, i)` 구간의 합이다. (half open range)

### why half open range?
- `prefix[i]`를 `[0, i)`의 합으로 정의하면 `left == 0`인 경우에도 별도 예외 처리가 필요 없다.