class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numberToIndex = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            numberToIndex.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            int rest = target - nums[i];
            if (numberToIndex.containsKey(rest) && numberToIndex.get(rest) != i) {
                return new int[]{i, numberToIndex.get(rest)};
            }
        }

        return null;
    }
}