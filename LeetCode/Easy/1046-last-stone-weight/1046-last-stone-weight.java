class Solution {
    public int lastStoneWeight(int[] stones) {
        /**
        전체 원소에 대해 우선순위 큐에 넣기
        poll 2번 해서 가장 무거운 돌 2개 뽑기
        돌 무게 같으면, 다음 순회로 넘어가기
        돌 무게 다르면, 차감 후 우선순위 큐에 집어넣기
        우선순위 큐 속 사이즈가 1개 이하가 될 때까지
         */
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int stone : stones) {
            pq.offer(stone);
        } 

        while (pq.size() >= 2) {
            int stone1 = pq.poll();
            int stone2 = pq.poll();

            if (stone1 > stone2) {
                int newStone = stone1 - stone2;
                pq.offer(newStone);        
            } 
        }

        return pq.size() == 1 ? pq.poll() : 0;
    }
}