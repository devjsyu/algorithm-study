class Solution {
    public long solution(long n) {
        long sqrt = (long) Math.sqrt(n);
        
        return n == sqrt * sqrt ? (sqrt + 1) * (sqrt + 1) : -1;
    }
}