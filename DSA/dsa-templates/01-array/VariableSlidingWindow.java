/**
 * Pattern: Variable-size Sliding Window
 *
 * Consider when:
 * - 연속된 구간을 다룬다.
 * - window 크기가 고정되어 있지 않다.
 * - 특정 조건을 만족하도록 window를 확장/축소할 수 있다.
 *
 * Invariant:
 * - [left, right]가 현재 window이다.
 *
 * Skeleton:
 * 1. right를 이동하며 window 확장
 * 2. 새 원소를 window state에 추가
 * 3. 조건에 따라 left를 이동하며 window 축소
 * 4. 필요한 answer 갱신
 *
 * Complexity:
 * Usually O(N)
 */
public class VariableSlidingWindow {

    static int slidingWindow(int[] nums) {
        int left = 0;
        int windowState = 0;
        int answer = 0;

        for (int right = 0; right < nums.length; right++) {
            // 1. Expand
            windowState += nums[right];

            // 2. Shrink while necessary
            while (/* window를 줄여야 하는 조건 */) {
                windowState -= nums[left];
                left++;
            }

            // 3. 현재 window [left, right] 처리
            answer = /* ... */;
        }

        return answer;
    }
}