class Solution {
    public int[] findErrorNums(int[] nums) {
        int[] counting = new int[nums.length + 1]; // 1-indexed
        for (int num : nums) {
            counting[num]++;
        }

        int duplicated = -1;
        int missing = -1;

        for (int i = 1; i <= nums.length; i++) {
            if (counting[i] == 2) {
                duplicated = i;
            } else if (counting[i] == 0) {
                missing = i;
            }

            if (duplicated != -1 && missing != -1) {
                break;
            }
        }

        return new int[]{duplicated, missing};
    }
}