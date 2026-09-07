class Solution {
    public int search(int[] nums, int target) {
        // index 찾기
        int index = 0;
        int prev = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int curr = nums[i];
            if (curr < prev) {
                index = i;
                break;
            } else {
                prev = curr;
            }
        }

        // 배열 새로 만들기
        int[] arr = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[i] = nums[(i + index) % nums.length];
        }

        // 새 배열에서 이분 탐색하기
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (target == arr[mid]) {
                return (mid + index) % nums.length;
            } else if (target > arr[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }
}