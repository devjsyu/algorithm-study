class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] answer = new int[nums.length];

        int j = 0;
        int k = n;
        for (int i = 0; i < n; i++) {
            answer[2 * i] = nums[j];
            answer[2 * i + 1] = nums[k];
            j++;
            k++;
        }

        return answer;
    }
}