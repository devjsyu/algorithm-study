/**
Variable-size Sliding Window
 */
class Solution {
    public int pivotIndex(int[] nums) {
        int totalSum = 0;

        for (int num : nums) {
            totalSum += num;
        }

        int leftSum = 0;
        for (int left = 0; left < nums.length; left++) {
            // pivot 빼기
            totalSum -= nums[left];
            
            if (leftSum == totalSum) return left;
            
            // pivot 갱신
            leftSum += nums[left];
        }

        return -1;
    }
}