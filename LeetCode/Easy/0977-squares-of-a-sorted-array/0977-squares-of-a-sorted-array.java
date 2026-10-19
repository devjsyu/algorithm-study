class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int left = 0;
        int right = n - 1;

        int[] answer = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = nums[i] * nums[i];
        }

        int index = n - 1;
        while (left <= right) {
            if (nums[left] >= nums[right]) {
                answer[index] = nums[left];
                left++;
            } else {
                answer[index] = nums[right];
                right--;
            }
            index--;
        }

        return answer;
    }
}