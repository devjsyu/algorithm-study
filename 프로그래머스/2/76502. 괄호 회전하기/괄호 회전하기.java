import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Solution {
    public int solution(String s) {
        int length = s.length();
        ArrayDeque<Character> queue = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            queue.add(c);
        }
        HashMap<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');

        int count = 0;
        for (int i = 0; i < length; i++) {
            if (i != 0) {
                queue.add(queue.remove());
            }
            ArrayList<Character> list = new ArrayList<>(queue);
            if (isValid(list, map)) {
                count++;
            }
        }

        return count;
    }

    private boolean isValid(List<Character> list, HashMap<Character, Character> map) {
        ArrayDeque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < list.size(); i++) {
            Character removed = list.get(i);
            if (map.containsKey(removed)) {
                stack.push(removed);
            } else if (stack.isEmpty()) {
                return false;
            } else if (removed == map.get(stack.peek())) {
                stack.pop();
            } else {
                return false;
            }
        }
        return stack.isEmpty();
    }
}