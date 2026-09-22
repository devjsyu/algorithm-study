class Solution {
    public int[] solution(long n) {
        String string = String.valueOf(n);
        int length = string.length();
        int[] answer = new int[length];
        
        for (int i = length - 1; i >= 0; i--) {
            answer[length - 1 - i] = Character.getNumericValue(string.charAt(i));
        }
        
        return answer;
    }
}