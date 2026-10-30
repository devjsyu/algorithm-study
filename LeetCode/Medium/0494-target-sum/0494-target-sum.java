class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        // 필터링 1: 목표값을 애초에 만들 수 없는 경우
        if (Math.abs(target) > sum) {
            return 0;
        }

        // +로 분류된 숫자 부분집합을 P로 하고,-로 분류된 숫자 부분집합을 N으로 할 때,
        // P에 대해 연립 1차 방정식을 도출하여,
        // P = (target + sum) / 2
        int total = target + sum;

        // 필터링 2: P는 정수여야 한다.
        if (total % 2 != 0) {
            return 0;
        }

        int P = total / 2;
/**
        // dp[s]: 합 s를 만드는 부분집합의 개수
        int[] dp = new int[P + 1];

        // Base Case: 아무것도 선택하지 않는 방법
        dp[0] = 1;

        for (int num : nums) {
            // 각 숫자를 최대 한 번만 사용할 수 있도록 역순 순회
            for (int s = P; s >= num; s--) {
                dp[s] += dp[s - num];
            }
        }

        return dp[P];
    }
 */
    
        int n = nums.length;
        int[][] dp = new int[n + 1][P + 1];

        // Base Case
        dp[n][0] = 1;

        // Suffix DP
        for (int i = n - 1; i >= 0; i--) {
            for (int s = 0; s <= P; s++) {

                // nums[i]를 선택하지 않는 경우
                dp[i][s] = dp[i + 1][s];

                // nums[i]를 선택하는 경우
                if (s - nums[i] >= 0) {
                    dp[i][s] += dp[i + 1][s - nums[i]];
                }
            }
        }

        return dp[0][P];
    }
}