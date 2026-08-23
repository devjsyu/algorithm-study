import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        // 차량 진출 지점을 기준으로 오름차순 정렬
        Arrays.sort(routes, (a, b) -> Integer.compare(a[1], b[1]));
        
        int answer = 0;
        // 첫 카메라 위치를 고속도로 시작 전으로 초기화
        int lastCamera = -30001;
        
        // 순회
        for (int[] route : routes) {
            int entry = route[0];
            int exit = route[1];
            
            // 카메라 위치가 차량 진입 지점보다 앞에 있다면 새로운 카메라 필요
            if (lastCamera < entry) {
                lastCamera = exit;
                answer++;
            }
        }
        
        return answer;
    }
}