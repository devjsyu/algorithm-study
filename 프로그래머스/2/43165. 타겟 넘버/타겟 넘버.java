/**
Backtracking
O(2^N) 시간복잡도
*/
class Solution {
    static int answer;
    static int[] numbers;
    static int target;
    
    public int solution(int[] numbers, int target) {
        // static variable initialization
        answer = 0;
        this.numbers = numbers;
        this.target = target;
        
        // backtracking
        backtracking(0, 0);
        
        return answer;
    }
    
    private void backtracking(int state, int index) {
        // 종료 조건        
        // 끝까지 순회한 경우
        if (index == numbers.length) {
            // target 조건을 만족할 경우 누적 집계
            if (state == target) answer++;
            return;
        }
        
        // 재귀
        int current = numbers[index];

        // 더하기 연산
        backtracking(state + current, index + 1); 
        // 빼기 연산
        backtracking(state - current, index + 1);
    }
}