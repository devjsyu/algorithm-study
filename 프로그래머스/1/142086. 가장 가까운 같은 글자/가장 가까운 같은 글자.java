/**
Naive approach: O(N^2)
using counting array: Time Complexity - O(N), Space Complexity - O(N)
*/
import java.util.*;

class Solution {
    public int[] solution(String s) {
        int length = 'z' - 'a' + 1;
        int[] alphabet = new int[length];
        Arrays.fill(alphabet, -1);
        int[] answer = new int[s.length()];
        
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            answer[i] = alphabet[index] == -1 ? -1 : i - alphabet[index];
            alphabet[index] = i;
        }
                
        return answer;
    }
}