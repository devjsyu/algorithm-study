import java.util.HashMap;
import java.util.Stack;

class Solution {
    public int solution(String s) {
        HashMap<Character, Character> map = new HashMap<>();
        map.put('}', '{');
        map.put(')', '(');
        map.put(']', '[');

        // 회전을 위해 주어진 문자열 이어붙이기
        String extendedString = s + s;
        char[] charArray = extendedString.toCharArray();
        int length = s.length();
        int answer = 0;

        // for-loop
        for (int i = 0; i < s.length(); i++) {
            if (isValidString(map, charArray, i, length)) answer++;
        }

        return answer;
    }

    // 올바른 문자열 판별 메서드
    public boolean isValidString(HashMap<Character, Character> map, char[] charArray, int start, int length) {
        Stack<Character> stack = new Stack<>();

        for (int i = start; i < start + length; i++) {
            if (map.containsKey(charArray[i])) {
                if (stack.isEmpty()) return false;
                if (stack.peek() == map.get(charArray[i])) {
                    stack.pop();
                } else {
                    return false;
                }
            } else {
                stack.push(charArray[i]);
            }
        }
        return stack.isEmpty();
    }
}