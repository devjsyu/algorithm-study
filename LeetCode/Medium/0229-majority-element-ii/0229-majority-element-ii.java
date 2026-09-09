/**
Boyer Moore Majority vote algorithm
최대 2명이 n / 3 이상 득표 가능
 */

class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int candidate1 = 0;
        int candidate2 = 0;
        int count1 = 0;
        int count2 = 0;
        
        for (int num : nums) {
            // candidate 득표
            if (candidate1 == num) {
                count1++;
            } else if (candidate2 == num) {
                count2++;
            // candidate 초기화
            // candidate의 count가 0이 된 경우
            } else if (count1 == 0) {
                candidate1 = num;
                count1 = 1;
            } else if (count2 == 0) {
                candidate2 = num;
                count2 = 1;                
            // candidate1, 2 외 다른 사람이 득표할 경우
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
        if (count1 > threshold) answer.add(candidate1);
        if (count2 > threshold) answer.add(candidate2);

        return answer;
    }
}