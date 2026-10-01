### key takeaway
- `right`를 이동하면서 window 확장 -> 조건을 만족하면 `left`를 이동하면서 최대한 축소
- `while`이 `for` 안에 있어서 얼핏 $O(N^2)$처럼 보일 수 있지만 `left`는 전체 실행 동안 오른쪽으로 최대 n번만 움직이기 때문에 $O(N)$

### skeleton logic
```text
int left = 0;

for (int right = 0; right < n; right++) {
    // 1. right 원소를 window에 추가
    add(arr[right]);
    
    // 2. 조건에 따라 window 축소
    while (condition) {
        // 필요하다면 현재 window로 답 갱신
        updateAnswer(left, right);
        
        // left 원소 제거
        remove(arr[left]);
        left++;
    }
}
```