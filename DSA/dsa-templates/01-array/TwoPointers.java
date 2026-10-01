/**
 * Pattern: Two Pointers - Opposite Direction
 *
 * Consider when: "Can moving one pointer safely eliminate candindate?"
 * - 배열이 정렬되어 있다.
 * - 두 원소의 조합을 찾는다.
 * - 조건에 따라 탐색 범위를 한쪽씩 제거할 수 있다.
 *
 * Invariant:
 * - 정답 후보가 존재한다면 현재 [left, right] 범위 안에 있다.
 *
 * Complexity:
 * Time: O(N)
 * Space: O(1)
 */
public class TwoPointers {

    static boolean findPair(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int sum = nums[left] + nums[right];

            if (sum == target) {
                return true;
            }

            if (sum < target) {
                left++;
            } else {
                right--;
            }
        }

        return false;
    }
}