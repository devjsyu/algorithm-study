class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        List<Integer> ordered = Arrays.stream(nums).boxed().sorted().collect(Collectors.toList());

        int[] answer = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            answer[i] = ordered.indexOf(nums[i]);
        }

        return answer;
    }
}