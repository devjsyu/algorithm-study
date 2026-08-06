import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int evalRPN(String[] tokens) {
        Set<String> operators = new HashSet<>();
        operators.add("+");
        operators.add("-");
        operators.add("*");
        operators.add("/");

        Deque<Integer> stack = new ArrayDeque<>();
        for (String token : tokens) {
            System.out.println("the current token is " + token);
            
            if (!operators.contains(token)) {
                stack.push(Integer.parseInt(token));                
            } else if (stack.size() >= 2) {
                System.out.println("the current stack size is " + stack.size());
                
                int operand1 = stack.pop();
                System.out.println("the current operand1 is " + operand1);


                int operand2 = stack.pop();
                System.out.println("the current operand2 is " + operand2);

                char operator = token.charAt(0);
                int result = operateRPN(operand1, operand2, operator);
                System.out.println("the current result is " + result);
                
                stack.push(result);
            }
        }

        return stack.pop();
    }

    private int operateRPN(int operand1, int operand2, char operator) {
        int answer = 0;
        switch (operator) {
            case '+' :
                answer = operand1 + operand2;
                break;
            case '-' :
                answer = operand2 - operand1;
                break;
            case '*' :
                answer = operand1 * operand2;
                break;
            case '/' :
                answer = operand2 / operand1;
                break;
        }
        return answer;
    }
}