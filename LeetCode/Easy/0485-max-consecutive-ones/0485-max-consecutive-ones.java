class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int count = 0;
        int largest = 0;
        for (int num : nums) {
            if (num == 1) {
                count++;
            } else {
                if (largest < count) {
                    largest = count;
                }
                count = 0; 
            } 
        }
        if (largest < count) {
            largest = count;
        }
        return largest;
    }
}