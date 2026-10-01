class Solution {
    public int pivotIndex(int[] nums) {
        // Prefix Sum 초기화
        int[] prefixSum = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }

        // 왼쪽 경계값
        if (prefixSum[nums.length] - nums[0] == 0) {
            return 0;
        }
        
        // 조건식: nums[i] == prefixSum[nums.length] - 2 * prefixSum[i];
        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i] == prefixSum[nums.length] - 2 * prefixSum[i]) {
                return i;
            }
        }

        // 오른쪽 경계값
        if (prefixSum[nums.length - 1] == 0) {
            return nums.length - 1;
        }

        // 모든 조건 불만족할 경우
        return -1;
    }
}