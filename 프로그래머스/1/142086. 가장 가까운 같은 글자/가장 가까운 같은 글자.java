/**
Naive approach: O(N^2)
using a last-seen index array: Time Complexity: O(N), Auxiliary Space Complexity: O(1)
*/
import java.util.*;

class Solution {
    public int[] solution(String s) {
        // lastSeen[c] = most recent index where character c appeared
        int length = 'z' - 'a' + 1;
        int[] lastSeen = new int[length];
        Arrays.fill(lastSeen, -1);

        int[] answer = new int[s.length()];
        
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';

            answer[i] = lastSeen[index] == -1
                    ? -1
                    : i - lastSeen[index];

            lastSeen[index] = i;
        }
                
        return answer;
    }
}