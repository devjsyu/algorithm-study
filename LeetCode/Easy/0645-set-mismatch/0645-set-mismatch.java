class Solution {
    public int[] findErrorNums(int[] nums) {
        int[] count = new int[nums.length + 1];

        for (int i = 0; i < nums.length; i++) {
            count[nums[i]]++;
        }

        int missing = -1;
        int duplicated = -1;
        for (int i = 1; i <= nums.length; i++) {
            if (count[i] == 2) {
                duplicated = i;
            } else if (count[i] ==0) {
                missing = i;
            }
        }

        return new int[]{duplicated, missing};
    }
}