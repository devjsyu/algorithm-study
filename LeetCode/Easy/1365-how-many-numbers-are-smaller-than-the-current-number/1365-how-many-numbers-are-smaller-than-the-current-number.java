// 주어진 배열로 리스트를 초기화 한다
// 리스트를 오름차순으로 정렬한다
// 배열의 각 원소에 대해 리스트의 indexOf 메서드 호출한다
import java.util.*;

class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        List<Integer> list = Arrays.stream(nums).sorted().boxed().collect(Collectors.toList());

        int[] answer = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            answer[i] = list.indexOf(nums[i]);
        }

        return answer;
    }
}