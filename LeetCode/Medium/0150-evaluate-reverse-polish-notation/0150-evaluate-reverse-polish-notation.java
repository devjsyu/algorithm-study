/**
iterating tokens
    operand? push to the stack
    operator? pop the stack twice and push the result to the stack
 */
class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> operand = new ArrayDeque<>();

        int result = 0;
        for (String token : tokens) {
            if (token.length() == 1 && !Character.isDigit(token.charAt(0))) {
                int b = operand.pop();
                int a = operand.pop();

                switch (token.charAt(0)) {
                    case '+' :
                        result = a + b;
                        break;
                    case '-' :
                        result = a - b;
                        break;
                    case '*' :
                        result = a * b;
                        break;
                    case '/' :
                        result = a / b;
                        break;
                } 
                operand.push(result);
            } else {
                operand.push(Integer.parseInt(token));
            }
        }

        return operand.isEmpty() ? result : operand.pop();    
    }
}