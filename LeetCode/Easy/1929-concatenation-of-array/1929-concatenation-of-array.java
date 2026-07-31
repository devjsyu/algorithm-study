class Solution {
    public int[] getConcatenation(int[] nums) {
        int n = nums.length;
        int length = 2 * n;
        int[] answer = new int[length];
        for (int i = 0; i < length; i++) {
            answer[i] = nums[i % n];
        }
        return answer;
    }
}