### analysis
- 이 문제는 `Running Sum` 문제이다. 왼쪽에서 오른쪽으로 순차 탐색하면서 누적 합만 필요하기 때문이다.
> (뜻 풀이) Running Sum에서 Running은 '뛰다'가 아니라 '계속 이어지는', '진행 중인'이라는 의미로 사용됩니다.

#### Running Sum
- 누적 합을 변수에 유지
- 순차적으로 합을 갱신한 값 구할 때 사용

#### Prefix Sum
- 각 인덱스까지의 누적합을 별도 배열에 저장하고 재사용
- 여러 구간 합을 구할 때 효율적

#### Variable-size Sliding Window
- 연속 구간의 양 끝을 이동
- 조건을 최대로 만족하는 구간 구할 때 효율적


### code example
```java
/**
 * Running Sum
 *
 * Time: O(N)
 * Space: O(1)
 */
class Solution {
    public int pivotIndex(int[] nums) {
        int rightSum = 0;

        for (int num : nums) {
            rightSum += num;
        }

        int leftSum = 0;

        for (int pivot = 0; pivot < nums.length; pivot++) {
            rightSum -= nums[pivot];

            if (leftSum == rightSum) {
                return pivot;
            }

            leftSum += nums[pivot];
        }

        return -1;
    }
}
```