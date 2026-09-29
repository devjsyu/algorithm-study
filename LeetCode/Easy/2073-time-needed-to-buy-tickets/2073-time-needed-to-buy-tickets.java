class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        Queue<Buyer> queue = new ArrayDeque<>();
        for (int i = 0; i < tickets.length; i++) {
            queue.offer(new Buyer(i, tickets[i]));
        }

        int timePassed = 0;
        while (!queue.isEmpty()) {
            Buyer buyer = queue.poll();
            int index = buyer.index();
            int ticketsToBuy = buyer.ticketsToBuy();
            
            if (--ticketsToBuy > 0) {
                queue.offer(new Buyer(index, ticketsToBuy));
            }

            timePassed++;

            if (index == k && ticketsToBuy == 0) {
                break;
            }
        }

        return timePassed;
    }

    public record Buyer(int index, int ticketsToBuy) {}
}