class Solution {
    public int[] findErrorNums(int[] nums) {
        int[] answer = new int[2];
        Map<Integer, Integer> numberToCount = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            numberToCount.put(nums[i], numberToCount.getOrDefault(nums[i], 0) + 1);
        }

        for (int i = 1; i <= nums.length; i++) {
            if (!numberToCount.containsKey(i)) {
                answer[1] = i;
            } else if (numberToCount.get(i) == 2) {
                answer[0] = i;
            }
        }
        
        return answer;
    }
}