/**
중복되는 원소 제거하기
(최대 가짓수, N/2) 중 최솟값 반환
*/
import java.util.*;

class Solution {
    public int solution(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        
        return Math.min(nums.length / 2, set.size());
    }
}