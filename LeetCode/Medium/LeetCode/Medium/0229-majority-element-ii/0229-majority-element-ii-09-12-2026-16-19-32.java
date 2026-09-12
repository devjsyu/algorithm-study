class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int candidate1 = Integer.MIN_VALUE;
        int candidate2 = Integer.MIN_VALUE;
        int count1 = 0;
        int count2 = 0;

        for (int num : nums) {
            if (count1 == 0 && num != candidate2) {
                candidate1 = num;
                count1 = 1;
            } else if (count2 == 0 && num != candidate1) {
                candidate2 = num;
                count2 = 1;
            } else if (candidate1 == num) {
                count1++;
            } else if (candidate2 == num) {
                count2++;
            } else if (candidate1 != num && candidate2 != num) {
                count1--;
                count2--;
            }
        }

        count1 = 0;
        count2 = 0;
        for (int num : nums) {
            if (candidate1 == num) {
                count1++;
            } else if (candidate2 == num) {
                count2++;
            }
        }

        int threshold = nums.length / 3;
        
        List<Integer> answer = new ArrayList<>();
        if (threshold < count1) answer.add(candidate1);
        if (threshold < count2) answer.add(candidate2);

        return answer;
    }
}