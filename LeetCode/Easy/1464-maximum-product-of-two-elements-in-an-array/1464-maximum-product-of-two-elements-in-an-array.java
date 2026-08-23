class Solution {
    public int maxProduct(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int num : nums) {
            pq.offer(num);
        }
        return (pq.poll() - 1) * (pq.poll() - 1);
    }
}