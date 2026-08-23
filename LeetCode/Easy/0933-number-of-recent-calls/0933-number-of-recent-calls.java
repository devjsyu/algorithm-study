import java.util.*;

class RecentCounter {
    Queue<Integer> calls;

    public RecentCounter() {
        calls = new ArrayDeque<>();
    }
    
    public int ping(int t) {
        calls.offer(t);

        while (calls.peek() < t - 3000) {
            calls.poll();
        }
        return calls.size();
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */