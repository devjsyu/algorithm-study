import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Solution {
    public static void main(String[] args) {
        int[][] board = {{0, 0, 0, 0, 0}, {0, 0, 1, 0, 3}, {0, 2, 5, 0, 1}, {4, 2, 4, 4, 2}, {3, 5, 1, 3, 1}};
        int[] moves = {1, 5, 3, 5, 1, 2, 1, 4};
        System.out.println(solution(board, moves));
    }
    public static int solution(int[][] board, int[] moves) {
        List<Stack<Integer>> list = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            list.add(new Stack<>());
        }
        for (int i = board.length - 1; i >= 0 ; i--) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] != 0) {
                    list.get(j).push(board[i][j]);
                }
            }
        }
        int count = 0;
        Stack<Integer> box = new Stack<>();
        for (int i = 0; i < moves.length; i++) {
            Stack<Integer> stack = list.get(moves[i] - 1);

            if (stack.isEmpty()) {
                continue;
            }

            if (!box.isEmpty() && box.peek().equals(stack.peek())) {
                box.pop();
                stack.pop();
                count += 2;
            } else {
                box.push(stack.pop());
            }
        }

        return count;
    }
}