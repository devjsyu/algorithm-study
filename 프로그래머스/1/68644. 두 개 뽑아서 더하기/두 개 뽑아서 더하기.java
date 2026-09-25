// double for-loop로 두 개의 수 뽑아서 더한 값을 Set에 추가하여 중복 제거하기
// Set을 오름차순 배열로 변환하기
import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        Set<Integer> set = new HashSet<>();
        
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                set.add(numbers[i] + numbers[j]);
            }
        }
        
        List<Integer> list = new ArrayList<>(set);
        
        return list.stream().sorted().mapToInt(Integer::intValue).toArray();
    }
}