class Solution {
    public int findKthLargest(int[] nums, int k) {
        /**
        k개 Heap 초기화
        순회하면서 기존 k-th보다 높으면 push, 기존 k-th는 pop
        만약 낮으면 무시하고 다음으로 넘어가기
         */       
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < k; i++) {
            pq.offer(nums[i]);
        }

        for (int i = k; i < nums.length; i++) {
            if (nums[i] > pq.peek()) {
                pq.poll();
                pq.offer(nums[i]);
            } else {
                continue;
            }
        }

        return pq.poll();
    }
}