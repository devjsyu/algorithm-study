### Analysis
- `Lower Bound Binary Search`
- 문제 요구사항: `target`이 들어갈 가장 앞선 위치 = **`target` 이상($\ge$)인 값이 처음 등장하는 인덱스**

### How I solved
- 순수 `Lower Bound` 방식으로 탐색 범위를 좁혀 최종 수렴 위치(`left` 또는 `right`)를 반환
    - `left` 초기값: 배열의 첫 번째 인덱스 `0`
    - `right` 초기값: `nums.length - 1`이 아닌 `nums.length`
        - 배열의 모든 원소가 target보다 작을 경우 맨 뒤(`length`)에 삽입되어야 하므로 가상의 앵커를 박아둠.
    - 조건 판별:
        - `nums[mid] >= target`: 현재 `mid`가 정답 후보이므로, **_`mid`를 버리지 않고_** `right = mid`로 말뚝을 당겨 박는다. (조기 반환 없이 끝까지 탐색)
        - `nums[mid] < target`: 확실한 오답 구간이므로, `left = mid + 1`로 고무줄을 당겨 범위를 좁힌다.
    - 반복 조건은 `left < right`이며, 루프 종료 시 `left == right`가 되어 정확한 삽입 위치를 가리킨다.

### Key Takeaway
- `target` 이상($\ge$)의 첫 자리를 찾는 것은 **Upper Bound가 아니라 Lower Bound**다.
- `right`는 정답 후보를 지키는 **"말뚝(앵커)"**, `left`는 오답을 지워가며 다가가는 **"고무줄"**로 기억하자.