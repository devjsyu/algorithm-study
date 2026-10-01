/**
 * Pattern: Fixed-size Sliding Window
 *
 * Consider when:
 * - 연속된 구간을 다룬다.
 * - window의 크기가 고저오디어 있다.
 * - 각 구간의 합/평균/개수 등을 반복해서 계산한다.
 *
 * Core idea:
 * - 새로 들어오는 값을 추가한다.
 * - window에서 빠지는 값을 제거한다.
 *
 * Complexity:
 * Time: O(N)
 * Space: O(1) // 단순 합을 관리하는 경우
 */
public class FixedSlidingWindow {

    static int maxWindowSum(int[] nums, int k) {
        int windowSum = 0;

        // 첫 번째 window
        for (int i = 0; i < k; i++) {
            windowSum += nums[i];
        }

        int answer = windowSum;

        // window 이동
        for (int right = k; right < nums.length; right++) {
            windowSum += nums[right];       // 들어오는 값
            windowSum -= nums[right - k];   // 나가는 값

            answer = Math.max(answer, windowSum);
        }

        return answer;
    }
}