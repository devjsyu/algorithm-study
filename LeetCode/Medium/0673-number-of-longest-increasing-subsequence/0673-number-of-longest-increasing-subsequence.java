import java.util.*;

class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;

        // length[i]: nums[i]에서 끝나는 LIS 최대 길이
        int[] length = new int[n];
        
        // count[i]: nums[i]에서 끝나는 최대 길이 LIS의 개수
        int[] count = new int[n];
        
        Arrays.fill(length, 1);
        Arrays.fill(count, 1);

        int maxLength = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {

                // 증가 부분수열을 만들 수 없는 경우
                if (nums[j] >= nums[i]) {
                    continue;
                }

                // 더 긴 LIS를 발견한 경우
                if (length[i] < 1 + length[j]) {
                    length[i] = 1 + length[j];
                    count[i] = count[j];
                }

                // 같은 길이의 LIS를 추가로 발견한 경우
                else if (length[i] == 1 + length[j]) {
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