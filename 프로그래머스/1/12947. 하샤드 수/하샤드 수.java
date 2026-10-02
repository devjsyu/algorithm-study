class Solution {
    public boolean solution(int x) {
        int sum = 0;
        int temp = x;
        
        while (temp / 10 > 0) {
            sum += temp % 10;
            temp /= 10;
        }
        sum += temp;
        
        return x % sum == 0;
    }
}