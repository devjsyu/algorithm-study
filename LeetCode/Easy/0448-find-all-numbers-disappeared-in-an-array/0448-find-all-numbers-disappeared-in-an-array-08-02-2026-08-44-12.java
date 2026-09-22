class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int[] allNumbers = new int[nums.length];
        List<Integer> list = new ArrayList<>();
        
        for (int i = 0; i < nums.length; i++) {
            allNumbers[nums[i] - 1]++;
        }

        for (int i = 0; i < nums.length; i++) {
            if (allNumbers[i] == 0) {
                list.add(i + 1);
            }
        }

        return list;
    }
}