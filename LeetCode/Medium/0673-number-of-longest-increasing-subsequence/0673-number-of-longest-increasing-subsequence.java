/**
- Subproblems
    - L(i) = prefix subset nums[:i] 범위에서 nums[i]로 끝나는 LIS 길이
    - C(i) = prefix subset nums[:i] 범위에서 nums[i]로 끝나는 LIS 개수

- Relate
    - L(i) = 1 + max{L(j) | 0 <= j < i} (nums[j] < nums[i])
    - C(i) = sum{C(j) | 0 <= j < i, max{L(j) + 1}를 만족하는 j} (nums[j] < nums[i])

- Topological Order
    - for i : 0, ..., n - 1
        for j : 0, ..., i - 1

- Base Case
    - L(0) = 1
    - C(0) = 1

- Original Problem
    - C(n - 1)

- Time Complexity
    - O(N^2)
 */
import java.util.*;

class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;

        int[] length = new int[n];
        int[] count = new int[n];

        Arrays.fill(length, 1);
        Arrays.fill(count, 1);

        int maxLength = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                // LIS 조건 미충족일 경우 필터링
                if (nums[j] >= nums[i]) {
                    continue;
                }

                // LIS 상태 갱신될 경우
                if (1 + length[j] > length[i]) {
                    length[i] = 1 + length[j];
                    count[i] = count[j];
                }

                // LIS 상태 유지될 경우
                else if (1 + length[j] == length[i]) {
                    count[i] += count[j];
                }
            }

            maxLength = Math.max(maxLength, length[i]);
        }

        int answer = 0;
        for (int i = 0; i < n; i++) {
            if (maxLength == length[i]) {
                answer += count[i];
            }
        }

        return answer;
    }
}