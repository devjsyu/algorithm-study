import java.util.ArrayDeque;
import java.util.HashMap;

class Solution {
    public int solution(String s) {
        // 괄호 종류별 열고 닫는 문자 짝지어 저장하기
        HashMap<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');

        int length = s.length();

        // 문자열 회전을 위해 동일한 문자열 연달아 이어붙이기
        s += s;

        int count = 0;
        
        // 문자열 회전을 위해 이중 반복문으로 순회하기 
        A:for (int i = 0; i < length; i++) {
            ArrayDeque<Character> stack = new ArrayDeque<>();
            for (int j = i; j < i + length; j++) {
                char c = s.charAt(j);
                if (map.containsKey(c)) {
                    stack.push(c);
                } else if (stack.isEmpty() || map.get(stack.peek()) != c) {
                    continue A;
                } else {
                    stack.pop();
                }
            }
            if (stack.isEmpty()) {
                count++;
            }
        }

        return count;
    }
}