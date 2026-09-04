import java.util.*;

class Solution {
    /**
    - 최적화 문제를 결정 문제로 전환하여 Parametric Search 사용
        - 최적화 문제 (각 지점 사이의 거리의 최솟값 중 가장 큰 값을 구하시오)
        - 결정 문제 (각 지점 사이의 거리, x가 바위 n개 제거로 가능한가?)
        
    - 결정 문제
    x가 1일 때 바위 n개 제거로 가능?
    x가 2일 때 바위 n개 제거로 가능?
    ...
    x가 1,000,000,000일 때 바위 n개 제거로 가능?
    
    - upper bound
    x가 x'일 때 바위 n개 이하로 제거 가능? -> x'보다 더 커도 된다
    x가 x'일 때 바위 n개 초과로 제거 가능? -> x'보다 더 작아야 한다
    
    - Monotonic
    x가 커질수록 판별함수의 값도 커진다
    (당연히 각 지점 사이의 거리를 늘리기 위해서는 제거해야 하는 바위 수가 많아진다)
    */
    public int solution(int distance, int[] rocks, int n) {
        // rocks 배열 오름차순 정렬
        Arrays.sort(rocks);
        
        // 변수 초기화
        int left = 1; // 각 지점 사이의 거리 최솟값
        int right = distance; // 각 지점 사이의 거리 최댓값
        int answer = 0;
        
        // Parametric Search with iterative approach 
        while (left <= right) {
            int middle = (left + right) / 2;
            
            int result = check(distance, rocks, middle);
            if (n >= result) {
                answer = middle;
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        
        return answer;
    }
    
    // 각 지점 사이의 거리 : x
    // 제거해야 하는 바위 개수 : 반환값
    private int check(int distance, int[] rocks, int x) {
        int rockCount = 0;
        int current = 0;
        
        for (int rock : rocks) {
            if (rock - current >= x) {
                current = rock;
            } else {
                rockCount++;
            }    
        }
        
        if (distance - current < x) {
            rockCount++;
        } 
        
        return rockCount;
    }
}