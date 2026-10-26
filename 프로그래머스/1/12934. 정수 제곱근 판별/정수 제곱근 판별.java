class Solution {
    public long solution(long n) {
        double sqrt = Math.sqrt(n);
        
        return (long) sqrt * sqrt == n ? ((long) sqrt + 1) * ((long) sqrt + 1) : -1;
    }
}