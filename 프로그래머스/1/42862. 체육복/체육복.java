import java.util.Arrays;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int[] students = new int[n + 1]; // 1번부터 n번까지 사용

        // 1. 도난당한 학생 반영 (-1)
        for (int l : lost) {
            students[l]--;
        }

        // 2. 여벌 있는 학생 반영 (+1)
        // (여벌이 있으면서 도난당한 학생은 0이 되어 자동으로 해결됨)
        for (int r : reserve) {
            students[r]++;
        }

        // 3. 체육복 빌려주기 (그리디: 앞 번호 우선 탐색)
        for (int i = 1; i <= n; i++) {
            if (students[i] == -1) {
                // 앞 번호 학생에게 빌릴 수 있는 경우
                if (i - 1 >= 1 && students[i - 1] == 1) {
                    students[i]++;
                    students[i - 1]--;
                } 
                // 뒷 번호 학생에게 빌릴 수 있는 경우
                else if (i + 1 <= n && students[i + 1] == 1) {
                    students[i]++;
                    students[i + 1]--;
                }
            }
        }

        // 4. 체육 수업에 참여할 수 있는 학생 수 카운트 (체육복이 0개 이상인 학생)
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            if (students[i] >= 0) {
                answer++;
            }
        }

        return answer;
    }
}