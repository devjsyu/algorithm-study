class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            // 왼편이 온전히 정렬된 경우
            if (nums[mid] > nums[right]) {
                // 오른편에 최솟값이 존재
                left = mid + 1;
            } else { // 오른편이 온전히 정렬된 경우
                // 왼편에 최솟값이 존재
                right = mid;
            }
        }

        return nums[left];
    }
}