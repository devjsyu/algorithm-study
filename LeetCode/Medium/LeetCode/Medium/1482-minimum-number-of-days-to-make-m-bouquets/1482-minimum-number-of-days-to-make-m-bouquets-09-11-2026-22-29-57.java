// 최적화 문제를 단조성을 띈 결정 함수로 전환하여 이분탐색 하기
// x: 시간 
// f(x): 만들 수 있는 bouquet 개수 
// Leftmost True 찾기
import java.math.BigInteger;

class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        // 결정론적으로 탈락 판정하기
        if (bloomDay.length < (long) m * k) {
            return -1;
        }

        int left = 1;
        int max = 0;
        for (int day : bloomDay) {
            if (max < day) max = day;
        }
        int right = max;

        int answer = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (m <= check(mid, bloomDay, k)) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return answer;
    }

    private int check(int x, int[] bloomDay, int k) {
        int[] nums = new int[bloomDay.length];
        Arrays.fill(nums, 0);

        for (int i = 0; i < bloomDay.length; i++) {
            if (bloomDay[i] <= x) {
                nums[i] = 1;
            }
        }

        int count = 0;
        int possible = 0;
        for (int i = 0; i < bloomDay.length; i++) {
            if (nums[i] == 1) {
                possible++;
            } else {
                count += possible / k;
                possible = 0;
            }
        }
        count += possible / k;

        return count;
    }
}