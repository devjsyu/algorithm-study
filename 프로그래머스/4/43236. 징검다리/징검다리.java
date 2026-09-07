/**
최적화 문제를 단조성 있는 결정 문제로 전환하여 이분 탐색으로 풀기
- AS-IS: 특정 조건을 만족하는 최댓값은 무엇인가?
- TO-BE: "x일 때 특정 조건을 만족하는가?" 결정 함수에 대한 Rightmost True 찾기

- 거리의 최솟값이 x일 때, 제거해야 하는 바위가 n이다. n이 주어졌을 때, 조건을 만족하는 x의 최댓값은?
*/

import java.util.*;

class Solution {
    public int solution(int distance, int[] rocks, int n) {
        // 주어진 배열 오름차순 정렬
        Arrays.sort(rocks);
        
        // x의 범위 초기화
        int left = 1;
        int right = distance;
        
        // 이분탐색
        int answer = 0;
        while (left <= right) {
            int middle = (left + right) / 2;
            
            // Rightmost True 찾기
            if (n >= check(middle, rocks, distance)) {
                answer = middle; // 정답 갱신
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        
        return answer;
    }
    
    // Greedy algorithm
    // 거리의 최솟값 x를 만족시키기 위해 제거해야 하는 바위의 개수 반환
    private int check(int x, int[] rocks, int distance) {
        // 출발지점 초기화
        int curr = 0;

        // 바위 순회하며 x를 만족하는지 조사
        int rockCount = 0;
        for (int rock : rocks) {
            if (rock - curr < x) {
                // 기존 curr 유지하면서 바위 누적 집계하기
                rockCount++;
            } else {
                // curr 갱신하기
                curr = rock;
            }
        }
        
        // 도착지점 조사
        if (distance - curr < x) {
            rockCount++;
        }
        
        return rockCount;
    }
}