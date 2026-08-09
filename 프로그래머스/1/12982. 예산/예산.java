import java.util.*;

class Solution {
    public int solution(int[] d, int budget) {
        // 신청금액을 오름차순 정렬 후 작은 것부터 지원하면 항상 가장 많이 지원할 수 있다.
        
        // 신청금액 오름차순 정렬
        Arrays.sort(d);
        
        // 예산 작은 것부터 순회하면서 예산 최대치까지 누적 합산 후 총 지원 가능 부서 반환
        int spending = 0;
        int approved = 0;
        for (int i = 0; i < d.length; i++) {
            if (budget >= spending + d[i]) {
                spending += d[i];
                approved++;
            }
        }
        
        return approved;
    }
}