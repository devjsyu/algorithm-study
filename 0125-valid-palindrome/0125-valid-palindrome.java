import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

class Solution {
    public boolean isPalindrome(String s) {
        List<Character> list = new ArrayList<>();
        Deque<Character> stack = new ArrayDeque<>();

        // 문자 변경
        char[] charArray = s.toCharArray();
        for (char c : charArray) {
            if (!Character.isLetterOrDigit(c)) {
                continue;
            }
            c = Character.toLowerCase(c);
            list.add(c);
            stack.push(c);
        }

        // 팰린드롬 부합 여부 확인
        for (Character c : list) {
            if (c != stack.peek()) {
                return false;
            }
            stack.pop();
        }

        return true;
    }
}