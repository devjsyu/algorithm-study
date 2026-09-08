/**
 HashMap을 통한 집계 -> n / 3보다 빈도수 많은 것을 리스트에 담기
 */

import java.util.*;

class Solution {
    public List<Integer> majorityElement(int[] nums) {
        // HashMap을 통한 집계
        Map<Integer, Integer> count = new HashMap<>();
        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        // n / 3보다 빈도수 많은 것을 리스트에 담기
        int bar = nums.length / 3;
        List<Integer> answer = new ArrayList<>();
        
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            if (entry.getValue() > bar) {
                answer.add(entry.getKey());
            }
        }

        return answer;
    }
}