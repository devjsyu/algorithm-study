import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for (int l = 0; l < commands.length; l++) {
            int i = commands[l][0];
            int j = commands[l][1];
            int k = commands[l][2];
            
            int[] temp = new int[j - i + 1];
            int n = 0;
            for (int m = i - 1; m < j; m++) {
                temp[n] = array[m];
                n++;
            }
            Arrays.sort(temp);
            answer[l] = temp[k - 1];
        }
        
        return answer;
    }
}