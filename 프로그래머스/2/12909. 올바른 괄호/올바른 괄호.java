import java.util.ArrayDeque;

class Solution {
    boolean solution(String s) {
        int length = s.length();
        ArrayDeque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < length; i++) {
            if (s.charAt(i) == '(') {
                stack.push('(');
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                stack.pop();
            }
        }

        return stack.isEmpty();
    }
}