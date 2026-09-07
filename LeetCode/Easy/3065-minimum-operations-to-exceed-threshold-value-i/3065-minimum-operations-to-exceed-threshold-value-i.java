import java.util.*;

// Lower Bound
class Solution {
    public int minOperations(int[] nums, int k) {
        // 오름차순 정렬
        Arrays.sort(nums);

        int left = 0;
        int right = nums.length; // 주어진 배열 속 모든 원소가 조건 맞지 않는 경우 대비(주어진 배열 속 모든 원소가 조건에 맞지 않는 경우라면, left가 nums.length - 1이 된다)

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (k <= nums[mid]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }
}