class Solution {
    public int findNumbers(int[] nums) {
        int count = 0;
        for (int num : nums) {
            int length = Integer.toString(num).length();
            if (length % 2 == 0) {
                count++;
            }
        }
        return count;
    }
}