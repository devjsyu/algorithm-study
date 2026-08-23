import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        
        Map<Character, Integer> charToCount = new HashMap<>();
        
        for (int i = 0; i < s.length(); i++) {
            char letter = s.charAt(i);
            if (!charToCount.containsKey(letter)) {
                answer[i] = -1;
            } else {
                answer[i] = i - charToCount.get(letter);
            }
            charToCount.put(letter, i);
        }
        
        return answer;
    }
}