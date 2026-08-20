class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        // 각 학생별 체육복 개수
        int[] students = new int[n + 1]; // 인덱스가 곧 학생 번호
        
        // lost 배열과 reserve 배열의 정보에 맞춰 초기화 하기
        // 0이면 문제없고, -1이면 도난 당한 것이고, +1이면 잉여분 존재
        for (int l : lost) {
            students[l]--;
        }
        for (int r : reserve) {
            students[r]++;
        }
        
        // students 배열 순회하면서 도난 당한 학생이 도움을 받을 수 있는지 업데이트
        for (int i = 1; i <= n; i++) {
            if (students[i] == -1) {
                if (i - 1 >= 1 && students[i - 1] == 1) {
                    students[i]++;
                    students[i - 1]--;
                } else if (i + 1 <= n && students[i + 1] == 1) {
                    students[i]++;
                    students[i + 1]--;
                }
            }
        }
        
        // 각 인덱스별 원소값 중 0인 것만 집계하기
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            if (students[i] >= 0) {
                answer++;
            }
        }
        
        return answer;
    }
}