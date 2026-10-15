### analysis
- State Definition: 현재 위치에서 끝나는 최대 곱과 최소 곱을 동시에 관리한다.
- State Transition: 현재 원소만 선택하거나, 이전 최대, 최소 곱을 연장한다.
- Optimization: 직전 상태만 필요하므로 $O(1)$ 공간으로 최적화한다.
    - 현재 상태가 직전 상태에만 의존하므로 `Space-Optimized DP`이다.

### code
```java
/**
주어진 nums 배열을 순회하면서 아래 변수 업데이트
currentElement
maxProduct
minProduct
max (maxProduct가 오름차순으로 업데이트 된다는 보장이 없으므로 최댓값 따로 관리)
 */
class Solution {
    public int maxProduct(int[] nums) {
        int currentElement = nums[0];
        int maxProduct = nums[0];
        int minProduct = nums[0];
        int max = maxProduct;

        for (int i = 1; i < nums.length; i++) {
            currentElement = nums[i];
            
            int a = currentElement;
            int b = maxProduct * currentElement;
            int c = minProduct * currentElement;

            maxProduct = Math.max(a, Math.max(b, c));
            minProduct = Math.min(a, Math.min(b, c));
            
            max = Math.max(max, maxProduct);
        }

        return max;
    }
}
```