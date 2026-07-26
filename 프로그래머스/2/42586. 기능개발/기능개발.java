import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] remainingDays = new int[progresses.length];
        for (int i = 0; i <  progresses.length; i++) {
            remainingDays[i] = (100 - progresses[i] + speeds[i] - 1) / speeds[i];
        }
        
        List<Integer> temp = new ArrayList<>();
        int front = remainingDays[0];
        int sum = 1;
        for (int i = 1; i <  progresses.length; i++) {
            if (front >= remainingDays[i]) {
                sum++;
            } else {
                front = remainingDays[i];
                temp.add(sum);
                sum = 1;
            }
        }
        temp.add(sum);
        
        int[] answer = new int[temp.size()];
        for (int i = 0; i < temp.size(); i++) {
            answer[i] = temp.get(i);
        }
        return answer;
    }
}