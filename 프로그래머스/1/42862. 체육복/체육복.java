/**
- Greedy algorithm
    - 각 학생마다 최대한 체육복을 확보하는 결정을 하면, 최대한 많은 학생이 체육복을 확보할 수 있다.

- 주의점
    - 여벌 체육복이 있지만, 도난 당한 학생은 다른 학생에게 체육복을 빌려줄 수 없다.
*/
import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        // 의사결정에 사용할 통합 배열 초기화
        int[] clothes = new int[n + 1];
        Arrays.fill(clothes, 1);
        
        for (int r : reserve) {
            clothes[r]++;
        }
        
        for (int l : lost) {
            clothes[l]--;
        }
        
        // 0: 체육복을 빌려야 하는 학생
        // 1: 체육복 빌릴 필요 없는 학생
        // 2: 체육복 빌려줄 수 있는 학생
        
        for (int i = 1; i <= n; i++) {
            if (clothes[i] == 0) {
                if (i - 1 >= 1 && clothes[i - 1] == 2) {
                    clothes[i] = 1;
                    clothes[i - 1] = 1;
                } else if (i + 1 <= n && clothes[i + 1] == 2) {
                    clothes[i] = 1;
                    clothes[i + 1] = 1;
                }
            }
        }
        
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (clothes[i] >= 1) {
                count++;
            } 
        }
        
        return count;
    }
}