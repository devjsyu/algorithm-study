import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        this.array = array;
        
        int[] answer = new int[commands.length];
        for (int i = 0; i < commands.length; i++) {
            answer[i] = process(commands[i][0], commands[i][1], commands[i][2]);
        }
        
        return answer;
    }
    
    private int[] array;
    
    // 1-index
    private int process(int start, int end, int target) {
        int[] temp = new int[end - start + 1];
        
        for (int i = start - 1; i <= end - 1; i++) {
            temp[i - start + 1] = array[i];
        }
        
        Arrays.sort(temp);
        
        return temp[target - 1];
    }
}