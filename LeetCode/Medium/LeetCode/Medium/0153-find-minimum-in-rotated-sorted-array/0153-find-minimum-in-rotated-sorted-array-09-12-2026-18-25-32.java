/**
1. mid를 기준으로 왼쪽이든 오른쪽이든 완벽하게 정렬되어 있을 것이다.
2. 왼쪽 구간이 완벽하게 정렬되어 있다면, 최솟값은 오른쪽 구간에 있을 것이다.
    따라서, left = mid + 1로 갱신한다.
3. 오른쪽 구간이 완벽하게 정렬되어 있다면, 최솟값은 오른쪽 구간 또는 mid에 있을 것이다.
    따라서, right = mid로 갱신한다.
 */
class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            // 왼쪽 구간만 완벽하게 정렬되어 있는 경우
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else { // 오른쪽 구간만 완벽하게 정렬되어 있는 경우
                right = mid; // mid에 최솟값이 포함될 수 있다
            } 
        }

        return nums[left];
    }
}