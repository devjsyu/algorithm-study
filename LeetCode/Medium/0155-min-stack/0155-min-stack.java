import java.util.ArrayDeque;
import java.util.Deque;

class MinStack {
    // int[] 배열 및 size, ptr와 같은 변수 직접 수동 관리하지 않고 ArrayDeque 사용
    private Deque<Integer> stack = new ArrayDeque<>();
    private Deque<Integer> minStack = new ArrayDeque<>(); // 최솟값 관리 보조 스택

    public void push(int val) {
        stack.push(val);
        // 최솟값 스택이 비어있거나, 새 값이 현재 최솟값보다 작거나 같으면 추가
        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }
    }

    public void pop() {
        // 메인 스택에서 꺼내는 값과 최솟값 스택의 top이 같으면 함께 제거
        // (Integer 객체이므로 .equals() 사용)
        if (stack.peek().equals(minStack.peek())) {
            minStack.pop();
        }
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}