import java.util.*;

class Solution {
    public int[] findErrorNums(int[] nums) {
        int[] count = new int[nums.length + 1];

        for (int i = 0; i < nums.length; i++) {
            count[nums[i]]++;
        }

        int[] answer = new int[2];
        for (int i = 1; i <= nums.length; i++) {
            if (count[i] == 2) {
                answer[0] = i;
            } else if (count[i] ==0) {
                answer[1] = i;
            }
        }

        return answer;
    }
}