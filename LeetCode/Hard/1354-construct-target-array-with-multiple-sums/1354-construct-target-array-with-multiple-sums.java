/**
- target 배열 원소의 총 합 구하기
- 최대값 찾기
- 나머지 합 = 총 합 - 최대값
- (새 원소: 최대값 - 나머지 합)을 우선순위 큐에다가 넣기
- (최대값 - 나머지 합) = (최대값 - 총 합 + 최대값) = (2 * 최대값 - 총 합)
- 총 합 (-= 최대값, += 새 원소)

- early return case?
    - 새 원소가 0보다 작은 경우
 */
class Solution {
    public boolean isPossible(int[] target) {
        PriorityQueue<Long> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        long sum = 0;
        for (int num : target) {
            maxHeap.offer((long) num);
            sum += num;
        }

        while (true) {
            long max = maxHeap.poll();
            long restSum = sum - max;

            // 모든 값이 사실상 1까지 복원 가능한 상태
            if (max == 1 || restSum == 1) {
                return true;
            } 

            // 이전 값이 양수가 될 수 없음
            if (restSum == 0 || max <= restSum) {
                return false;
            }

            long previous = max % restSum;

            // 원소는 항상 양수여야 함
            if (previous == 0) {
                return false;
            }

            maxHeap.offer(previous);

            sum = restSum + previous;
        }
    }
}