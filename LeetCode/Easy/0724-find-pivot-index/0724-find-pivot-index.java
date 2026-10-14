/**
Prefix Sum
구간 합 반복 되는 경우, Prefix Sum을 사용하면 Naive Approach보다 더 효율적으로 탐색할 수 있다. 

prefix[i]: [0, i) 구간의 합
prefix[i] = prefix[i - 1] + nums[i - 1]
prefix[right + 1] - prefix[left] = [left, right] 구간의 합
 */
class Solution {
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        int[] prefix = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            prefix[i] = prefix[i - 1] + nums[i - 1];
        }

        int leftSum = 0;
        int rightSum = 0;
        for (int pivot = 0; pivot < n; pivot++) {
            rightSum = prefix[n] - prefix[pivot + 1];
            
            if (leftSum == rightSum) {
                return pivot;
            }

            leftSum += nums[pivot];
        }

        return -1;
    }
}