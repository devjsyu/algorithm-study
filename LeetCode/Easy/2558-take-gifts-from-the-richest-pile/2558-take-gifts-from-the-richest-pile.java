class Solution {
    public long pickGifts(int[] gifts, int k) {
        // Max Heap
        PriorityQueue<Long> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int gift : gifts) {
            pq.offer(Long.valueOf(gift));
        }
        
        for (int i = 0; i < k; i++) {
            if (pq.peek() > 1) {
                long sqrt = (long) Math.sqrt(pq.poll());
                pq.offer(sqrt);
            } else {
                break;
            }
        }

        List<Long> list = new ArrayList<>(pq);
        long sum = 0;
        for (long gift : list) {
            sum += gift;
        }

        return sum;
    }
}