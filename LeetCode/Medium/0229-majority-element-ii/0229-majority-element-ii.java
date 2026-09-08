/**
- Boyer Moore's Majority Vote algorithm을 활용하기
    - n / 3보다 큰 득표를 한 사람은 최대 2명일 수밖에 없다!

- 기존 Boyer Moore's Majority Vote algorithm 방식에서 변형
    - AS-IS: candidate, count
    - TO-BE: candidate1, count1, candidate2, count2

- 이전과 동일: count가 0이 될 때 candidate 교체하기
- 이번에 달라진 점: candidate 외 다른 사람 등장하면 count1, count2 동시 차감하기
 */

class Solution {
    public List<Integer> majorityElement(int[] nums) {
        Integer candidate1 = null;
        Integer candidate2 = null;
        int count1 = 0; 
        int count2 = 0;

        for (int num : nums) {
            if (candidate1 != null && num == candidate1) {
                count1++;
            } else if (candidate2 != null && num == candidate2) {
                count2++;
            } else if (count1 == 0) {
                candidate1 = num;
                count1 = 1;
            } else if (count2 == 0) {
                candidate2 = num;
                count2 = 1;
            } else {
                // 세 숫자가 모두 다르면 두 후보의 카운트를 1씩 차감
                count1--;
                count2--;
            }
        }

        count1 = 0;
        count2 = 0;
        for (int num : nums) {
            if (candidate1 != null && candidate1 == num) {
                count1++;
            } else if (candidate2 != null && candidate2 == num) {
                count2++;
            }
        }
        int threshold = nums.length / 3;

        List<Integer> answer = new ArrayList<>();
        if (count1 > threshold) {
            answer.add(candidate1);
        }
        if (count2 > threshold) {
            answer.add(candidate2);
        }

        return answer;
    }
}