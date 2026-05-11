## 1. 어떻게 시도했는가? (How)
- 초기 접근이 지지부진해서 궁여지책으로 PASS 했다. 공간복잡도와 시간복잡도가 비효율적인 방식으로 풀었다.
- 초기 접근은 임의의 추가 공간을 활용하는 Merge Sort 아이디어를 적용하고자 했다. 
  - 하지만 한 쪽 원소가 남아도는 상황을 매끄럽게 조건식에 반영하지 못했다.
  - 조건식이 지나치게 복잡해졌다. 
- 어쨌든 내 힘으로 풀기 위해 다소 비효율적인 접근 방식으로, Queue와 List를 이용했다. 
  - 심지어 Queue를 사용했어도 조건식 분기가 많아지고 조건식 깊이가 여전히 깊어져서 보기 안 좋았다.
- 반면, `Two Pointers` 접근 방식을 사용하면 시간복잡도 O(M+N), 공간복잡도 O(1) 제약조건을 만족시킬 수 있다.

## 2. 한 줄 본질 (What)
- "이 문제는 결국 `Two Pointers`으로 두 배열의 각 원소를 비교해가며 정렬하는 것이다."

## 3. 아차! 포인트 (Why)
- "내가 막혔던 이유는 `잔여 원소가 있는 상황을 다루는 방법`을 놓쳐서였다." (딱 하나만!)
  - 조건식 하나에 모든 걸 다 쑤셔넣을 필요가 없었다. scope를 분리했으면 간단하게 풀 수 있었다.

### 내가 풀고자 했던 접근 방법의 올바른 풀이 예시
```java
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] tempArray = new int[m + n];
        
        int i = 0; // nums1의 인덱스
        int j = 0; // nums2의 인덱스
        int k = 0; // tempArray의 인덱스

        // 1. 두 배열 모두에 비교할 숫자가 남아있는 동안
        while (i < m && j < n) {
            if (nums1[i] <= nums2[j]) {
                tempArray[k++] = nums1[i++];
            } else {
                tempArray[k++] = nums2[j++];
            }
        }

        // 2. 만약 nums1에 남은 숫자가 있다면 마저 채우기
        while (i < m) {
            tempArray[k++] = nums1[i++];
        }

        // 3. 만약 nums2에 남은 숫자가 있다면 마저 채우기
        while (j < n) {
            tempArray[k++] = nums2[j++];
        }

        // 4. 최종 결과를 nums1에 복사
        for (int x = 0; x < m + n; x++) {
            nums1[x] = tempArray[x];
        }
    }
}
```

## 4. 다음에 보면? (Trigger)
- "`이미 정렬된 두 배열`이 보이면 다음엔 `while 조건문을 scope를 나누어서 필터링`하는 것부터 떠올리자."
  - if-else 조건문으로 분기를 복잡하게 작성하면 가독성도 안 좋고 실수할 가능성도 높다.
  - 반면, scope를 나누고 각 scope마다 while 조건문을 사용하면 자연스럽게 코드 흐름에 따라 필터링되는 효과가 있다.