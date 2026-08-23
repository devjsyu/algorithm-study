import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        // 몸무게 가벼운 사람과 무거운 사람을 짝지으면 보트 사용을 최소한으로 가능
        
        // 몸무게 오름차순 정렬
        Arrays.sort(people);
        
        int count = 0;                
        int escaped = 0;
        int leftIndex = 0;
        int rightIndex = people.length - 1;
        boolean isPossibleForTwo = true;
        
        while (escaped < people.length) {
            // 가능한 가장 무게 가벼운 사람과 가장 무게 무거운 사람 짝짓기
            if (limit - people[rightIndex] >= people[leftIndex]) {
                count++;
                escaped += 2;
                rightIndex--;
                leftIndex++;
            } else {
                count++;
                escaped += 1;
                rightIndex--;
            }
        }
        
        return count;
    }
}