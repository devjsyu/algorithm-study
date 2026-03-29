import java.util.Stack;
import java.util.StringTokenizer;

class Solution {
    public int solution(String s) {
        Stack<Integer> stack = new Stack<>();
        StringTokenizer st = new StringTokenizer(s);

        while (st.hasMoreTokens()) {
            String token = st.nextToken();
            if (token.equals("Z")) {
                stack.pop();
            } else {
                stack.push(Integer.parseInt(token));
            }
        }

        int sum = 0;
        while (!stack.isEmpty()) {
            sum += stack.pop();
        }

        return sum;
    }
}