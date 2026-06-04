class Solution {
    public int solution(int n, int a, int b) {
        // iterate until ceiling division results for two parameters are same
        int answer = 1;
        
        while ((a + 1) / 2 != (b + 1) / 2) {
            answer++;
            a = (a + 1) / 2;
            b = (b + 1) / 2;
        }

        return answer;
    }
}