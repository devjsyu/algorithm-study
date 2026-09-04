import java.util.*;

class Solution {
    public int solution(int distance, int[] rocks, int n) {
        Arrays.sort(rocks);
        int left = 1;
        int right = distance;
        int answer = 0;
        
        while (left <= right) {
            int middle = (left + right) / 2;
            
            if (n >= check(distance, rocks, middle)) {
                answer = middle;
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        
        return answer;
    }
    
    // Greedy approach
    // 간격을 인자로 두고, 제거해야 하는 돌의 개수를 반환
    private int check(int distance, int[] rocks, int x) {
        int rockCount = 0;
        
        int current = 0;
        
        for (int i = 0; i < rocks.length; i++) {
            if (rocks[i] - current < x) {
                rockCount++;
            } else {
                current = rocks[i];            
            }
        }
        
        if (distance - current < x) {
            rockCount++;
        }
        
        return rockCount;
    }
}