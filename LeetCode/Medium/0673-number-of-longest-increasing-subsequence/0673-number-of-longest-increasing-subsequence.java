/**
LIS 자체에 대한 상태 관리
LIS 최댓값에 의존하는 LIS 개수 상태 관리
=> 인덱스에 대한 2가지 상태 관리 필요
 */
import java.util.*;

class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;

        int[] length = new int[n + 1];
        int[] count = new int[n + 1];

        Arrays.fill(length, 1);
        Arrays.fill(count, 1);

        length[n] = 0;
        count[n] = 0;

        int maxLength = 0;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                // 필터링 : LIS 조건 미충족
                if (nums[i] >= nums[j]) {
                    continue;
                }

                // LIS 갱신
                if (1 + length[j] > length[i]) {
                    length[i] = 1 + length[j];
                    count[i] = count[j]; 
                }

                // LIS 유지
                else if (1 + length[j] == length[i]) {
                    count[i] += count[j];
                }
            }

            maxLength = Math.max(maxLength, length[i]);
        }

        int answer = 0;
        for (int i = 0; i < n; i++) {
            if (length[i] == maxLength) {
                answer += count[i];
            }
        }

        return answer;
    }
}