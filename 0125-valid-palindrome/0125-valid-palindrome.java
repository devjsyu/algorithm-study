import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

class Solution {
    public boolean isPalindrome(String s) {
        List<Character> list = new ArrayList<>();

        // 문자 변경
        char[] charArray = s.toCharArray();
        for (char c : charArray) {
            if (!Character.isLetterOrDigit(c)) {
                continue;
            }
            c = Character.toLowerCase(c);
            list.add(c);
        }

        // Two Pointers를 위한 변수 및 배열 초기화
        int p1 = 0;
        int p2 = list.size() - 1;
        Character[] array = list.toArray(Character[]::new);

        // 팰린드롬 부합 여부 확인
        for (int i = 0; i < array.length; i++) {
            if (array[p1++] != array[p2--]) {
                return false;
            }
        }

        return true;
    }
}