import java.util.HashMap;
import java.util.Stack;

class Solution {
    public int solution(String s) {
        String extended = s + s;
        char[] charArray = extended.toCharArray();
        
        int answer = 0;

        Stack<Character> stack = new Stack<>();
        HashMap<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');

        outerLoop:
        for (int i = 0; i < s.length(); i++) {
            stack.clear();

            for (int j = i; j < i + s.length(); j++) {
                char c = charArray[j];
                if (!map.containsKey(c)) {
                    stack.push(c);
                } else if (!stack.isEmpty() && stack.peek() == map.get(c)) {
                    stack.pop();
                } else {
                    continue outerLoop;
                }
            }
            if (stack.isEmpty()) {
                answer++;
            }
        }
        return answer;
    }
}