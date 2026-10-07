/**
K way merge with min heap
우선순위 큐 추가
- 초기: nums1[0]과 nums2의 모든 원소 조합
- 매번: min heap 기준 nums1의 다음 원소와 nums2 기존 원소의 조합 추가
 */
class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> answer = new ArrayList<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(Pair::sum));
        for (int i = 0; i < Math.min(k, nums2.length); i++) {
            pq.add(new Pair(0, i, nums1[0] + nums2[i]));
        }
        int count = 0;

        while (count < k && !pq.isEmpty()) {
            Pair current = pq.poll();
            int i = current.i();
            int j = current.j();

            answer.add(List.of(nums1[i], nums2[j]));
            count++;

            // 다음 후보를 PQ에 추가
            if (i < nums1.length - 1) {
                i++;
                pq.add(new Pair(i, j, nums1[i] + nums2[j]));
            }
        }

        return answer;
    }

    public record Pair(int i, int j, int sum) {}
}