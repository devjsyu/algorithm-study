import java.util.*;

public class Solution {
    public int[] solution(int[] arr) {
        // 직전 요소와 비교를 위해 Stack 사용
            // 자료구조 초기화
        Deque<Integer> stack = new ArrayDeque<>();
        List<Integer> answer = new ArrayList<>();
        
        // 주어진 배열 순회하면서 아래 규칙에 따라 Stack 초기화
        for (int i = 0; i < arr.length; i++) {
            // Stack이 비어있다면?
            if (stack.isEmpty()) {
                // Stack에 추가
                stack.add(arr[i]);
            } else {
            // 추가하려는 요소와 직전 요소 비교
                // 같다면?
                if (arr[i] == stack.peek()) {
                    continue;
                } else {
                // 다르다면?
                    answer.add(stack.pop());
                    stack.add(arr[i]);
                }
            }
        }
        answer.add(stack.pop());
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}