/**
State Definition
- LIS 길이에 대한 상태관리
- LIS 개수에 대한 상태관리

- length[i]: nums[i:] 수열에 대한 LIS 길이
- count[i] : nums[i:] 수열에 대한 LIS 개수


Transition
length[i] = nums[i] < nums[j] ? length[i + 1] + 1 : length[i + 1] (단, i < j < n)
count[i] = 동일 length[i]하면 => += count[i + 1]
           length[i] 갱신되면 => = count[i + 1]

Base Case
length[n - 1] = 1
count[n - 1] = 1

Original Problem
전체 범위에 대해 LCS 최댓값 개수를 구하기 위해 length[i]가 LCS 최댓값인 경우의 i에 대해 count[i]를 누적 집계하여 반환한다.  
 */
import java.util.*;

class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;

        int[] length = new int[n];
        int[] count = new int[n];
        Arrays.fill(length, 1);
        Arrays.fill(count, 1);

        int maxLength = 0;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                // 필터링: LCS가 아닌 경우
                if (nums[i] >= nums[j]) {
                    continue;
                }

                // LCS가 갱신된 경우
                if (1 + length[j] > length[i]) {
                    length[i] = 1 + length[j];
                    count[i] = count[j];
                }

                // LCS가 유지된 경우
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