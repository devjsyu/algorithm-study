class Solution {
    public long solution(long n) {
        double sqrt = Math.sqrt(n);
        if (n % sqrt == (double) 0) {
            return ((long) sqrt + 1) * ((long) sqrt + 1);
        } else {
            return -1;
        }        
    }
}