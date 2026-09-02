class Solution {
    public long solution(int n, int[] times) {
        // 가장 느린 심사원 찾기
        int slowest = 0;
        for (int time : times) {
            if (time > slowest) {
                slowest = time;
            }
        }
        // 가장 오래 걸리는 경우 : 가장 느린 심사원에게 모든 사람이 심사 받을 때
        long end = (long) slowest * n;
        
        // 가장 빨리 걸리는 경우 : 가장 빠른 심사원에게 1명이 심사 받을 때
        long start = 1; // 임의 초기화
        
        long answer = end; // 최악의 경우로 초기화
        
        while (start <= end) {
            long middle = start + (end - start) / 2;
                        
            long result = getCapacity(times, middle);
            
            // n명 이상 심사 가능한 경우: 정답 후보로 저장하고 더 짧은 시간 탐색
            if (result >= n) {
                answer = middle;
                end = middle - 1;
            } else {
                // n명 미만인 경우: 시간이 부족하므로 시간 늘리기
                start = middle + 1;
            }
        }
        
        return answer;
    }
    
    private long getCapacity(int[] times, long duration) {
        long capacity = 0;
        for (int time : times) {
            capacity += duration / time;
        }
        return capacity;
    }
}