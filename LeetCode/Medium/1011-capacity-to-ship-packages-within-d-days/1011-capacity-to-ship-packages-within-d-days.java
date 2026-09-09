/**
Parametric search

주어진 ship capacity로 처리할 수 있는 일수
Leftmost True
 */
class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int left = 1;

        int max = -1;
        for (int weight : weights) {
            if (weight > max) max = weight;
        }

        int right = max * weights.length;

        int answer = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (days >= check(weights, mid)) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return answer;
    }

    private int check(int[] weights, int capacity) {
        int days = 1;
        int currentLoad = 0;

        for (int weight : weights) {
            if (weight > capacity) {
                return Integer.MAX_VALUE;
            }

            if (currentLoad + weight > capacity) {
                days++;
                currentLoad = weight;
            } else {
                currentLoad += weight;
            }
        }
        
        return days;
    }
}