class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        // Queue 초기화
        Queue<Integer> ticketsToBuy = new ArrayDeque<>();
        for (int i = 0; i < tickets.length; i++) {
            ticketsToBuy.offer(i);
        }

        // tickets[k]가 0이 될 때까지 반복
        int timePassed = 0;
        while (tickets[k] != 0) {
            int polledIndex = ticketsToBuy.poll();
            tickets[polledIndex]--;
            if (tickets[polledIndex] > 0) {
                ticketsToBuy.offer(polledIndex);
            }
            timePassed++;
        }
        return timePassed;
    }
}