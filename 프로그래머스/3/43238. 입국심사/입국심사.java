/**
Binary Search
최적화 문제를 결정 문제로 전환하고, 판별 결과의 단조성이 보장될 때, Parametric Search를 적용할 수 있다.
- 최적화 문제 : 모든 사람 n명이 심사를 받는데 걸리는 시간의 최솟값을 구하시오
- 결정 문제 : 특정 시간 x 동안 심사를 받을 수 있는 사람의 수는? (판별함수)

Parametric Search를 위한 구성 요소
- x의 범위 (1초부터 '이론상 최대 심사 시간'까지)
- Monotonicity : x가 커질수록 f(x)의 값도 커진다 (시간이 넉넉할수록 심사 가능 인원 수도 많아진다)
- Leftmost True 탐색 : n명 이상이면서 x의 최솟값 구하기
    - f(x) >= n (가능) -> `answer = x` 갱신 후 더 적은 시간 탐색 (right = middle - 1)
    - f(x) < n (불가능) -> 시간을 더 늘려 탐색 (left = middle + 1)
*/

class Solution {
    public long solution(int n, int[] times) {

        // 가장 느린 심사관의 심사 소요 시간 구하기
        int slowest = 0;
        for (int time : times) {
            if (time > slowest) {
                slowest = time;
            }
        }
        long left = 1; // 이론상 심사 시간 최솟값
        long right = (long) slowest * n; // 이론상 심사 시간 최댓값 (가장 느린 심사관에게 모두 심사 받는 경우)
        long answer = 0;
        
        while (left <= right) {
            long middle = left + (right - left) / 2; // Overflow 방지 연산
            
            if (check(times, middle) >= n) {
                answer = middle;
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        
        return answer;
    }
    
    // 판별함수
    // 인자 x : 시간
    // 반환값 : 총 심사 가능 인원 수
    private long check(int[] times, long x) {
        // 각 심사관별 특정 시간 안에 처리할 수 있는 인원 수 : 제한시간 / 심사 소요 시간
        long count = 0;
        for (int time : times) {
            count += x / time; 
        }
        
        return count;
    }
}