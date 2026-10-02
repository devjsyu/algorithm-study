import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        
        int[] alphabets = new int[26];
        Arrays.fill(alphabets, -1);
        
        for (int i = 0; i < s.length(); i++) {
            int index = (int) s.charAt(i) - 'a';
            if (alphabets[index] == -1) {
                answer[i] = -1;
            } else {
                answer[i] = i - alphabets[index];
            }
            alphabets[index] = i;
        }
        
        return answer;
    }
}