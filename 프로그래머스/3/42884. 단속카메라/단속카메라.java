import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        // 주어진 배열을 진출 지점 기준으로 오름차순 정렬
        Arrays.sort(routes, (v1, v2) -> {
            return v1[1] - v2[1];
        });
        
        int count = 0;
        int previousCamera = Integer.MIN_VALUE;
        for (int i = 0; i < routes.length; i++) {
            // 직전 카메라 위치와 진입지점 비교해서 설치 생략 여부 판단
            if (previousCamera >= routes[i][0]) {
                continue;
            } else {
                count++;
                previousCamera = routes[i][1];
            }
        }
        
        return count;
    }
}