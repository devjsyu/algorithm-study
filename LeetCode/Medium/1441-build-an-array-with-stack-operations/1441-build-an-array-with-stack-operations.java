import java.util.*;

class Solution {
    public List<String> buildArray(int[] target, int n) {
        List<String> answer = new ArrayList<>();

        int targetIndex = 0;

        for (int num = 1; num <= n; num++) {
            // target을 모두 만들었다면 더 읽을 필요가 없다.
            if (targetIndex == target.length) {
                break;
            }

            answer.add("Push");

            if (num == target[targetIndex]) {
                // 필요한 숫자를 찾았다.
                targetIndex++;
            } else {
                // 필요 없는 숫자이므로 바로 제거한다.
                answer.add("Pop");
            }
        }

        return answer;
    }
}