import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                int sum = numbers[i] + numbers[j];
                if (!set.contains(sum)) set.add(sum);
            }
        }
        
        List<Integer> list = new ArrayList<>(set);
        
        return list.stream().sorted().mapToInt(Integer::intValue).toArray();
    }
}