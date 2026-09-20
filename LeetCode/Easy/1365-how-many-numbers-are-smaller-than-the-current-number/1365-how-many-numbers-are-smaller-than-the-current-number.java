class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        List<Integer> ordered = new ArrayList<>();
        for (int num : nums) {
            ordered.add(num);
        }
        Collections.sort(ordered);

        int[] answer = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            answer[i] = ordered.indexOf(nums[i]);
        }

        return answer;
    }
}