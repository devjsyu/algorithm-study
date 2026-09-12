// 최적화 문제를 단조성을 띈 결정 문제로 전환해 이분탐색 하기
// 속도 k가 커질수록, 시간 f(k)이 작아진다
// Leftmost True 구하기
class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = 0;

        for (int pile : piles) {
            right = Math.max(right, pile);
        }

        int answer = right;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (check(mid, piles, h)) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return answer;
    }

    private boolean check(int x, int[] piles, int h) {
        long time = 0;

        for (int pile : piles) {
            if (h < time) break;

            time += ((long) pile + (x - 1)) / x; // ceil 연산
        }

        return h >= time;
    }
}