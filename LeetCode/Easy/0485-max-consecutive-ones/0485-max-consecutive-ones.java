class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int count = 0;
        int largest = 0;
        for (int num : nums) {
            if (num == 1) {
                count++;
                largest = count > largest ? count : largest;
            } else {
                count = 0;
            }
        }

        return largest;
    }
}