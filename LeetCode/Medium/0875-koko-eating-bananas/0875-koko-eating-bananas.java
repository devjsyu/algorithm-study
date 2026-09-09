/**
Parametric search
최적화 문제를 단조성을 띈 결정 문제로 전환하여 이분 탐색으로 풀기

k가 커질수록 먹는 데에 드는 시간이 줄어든다
k가 주어졌을 때, 먹는 데에 드는 시간이 h보다 작거나 같은가?

Leftmost True
 */

class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = 1000000000;
        int answer = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (h >= check(piles, mid)) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return answer;
    }

    private long check(int[] piles, int k) {
        long time = 0;
        for (int pile : piles) {
            time += (pile + k - 1) / k;
        }
        return time;
    }
}