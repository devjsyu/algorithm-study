// Counting Array
import java.util.*;

class Solution {
    public int[] solution(String s) {
        int n = s.length();
        int[] counting = new int[26];
        Arrays.fill(counting, -1);
        int[] answer = new int[n];
        
        for (int i = 0; i < n; i++) {
            int index = s.charAt(i) - 'a';
            
            if (counting[index] == -1) {
                answer[i] = -1;
                counting[index] = i;
            } else {
                answer[i] = i - counting[index];
                counting[index] = i;
            }
        }
        
        return answer;
    }
}