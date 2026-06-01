import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

class Solution {
    // 자주 쓰이는 변수는 멤버 변수로 선언
    private final Map<Character, Character> map = new HashMap<>();
    private char[] charArray;
    private int length;

    public int solution(String s) {
        // 멤버 변수 초기화
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');

        String extended = s + s; // 주어진 문자열을 2배로 늘린 상태에서 일부 구간 순회하여 회전 구현
        charArray = extended.toCharArray();
        length = s.length();

        int answer = 0;

        for (int i = 0; i < length; i++) {
            // 유효한 문자열인지 검증
            if (isValid(i)) {
                answer++;
            }
        }

        return answer;
    }

    private boolean isValid(int start) {
        Deque<Character> stack = new ArrayDeque<>();

        for (int i = start; i < start + length; i++) {
            char c = charArray[i];
            if (!map.containsKey(c)) {
                stack.push(c);
            } else if (!stack.isEmpty() && stack.peek() == map.get(c)) {
                stack.pop();
            } else {
                return false;
            }
        }
        return stack.isEmpty();
    }
}