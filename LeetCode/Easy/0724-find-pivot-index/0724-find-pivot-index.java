class Solution {
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        
        int rightSum = 0;
        for (int num : nums) {
            rightSum += num;
        }
        rightSum -= nums[0];

        int leftSum = 0;

        for (int p = 0; p < n; p++) {
            if (leftSum == rightSum) {
                return p;
            } 

            leftSum += nums[p];

            if (p == n - 1) {
                rightSum = 0;
            } else {
                rightSum -= nums[p + 1];
            }
        }

        return -1;
    }
}