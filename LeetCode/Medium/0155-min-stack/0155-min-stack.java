import java.util.*;

class MinStack {
    private int size;
    private int ptr;
    private List<Integer> list;
    private Deque<Integer> minStack = new ArrayDeque<>();

    public MinStack() {
        this.size = 0;
        this.ptr = -1;
        this.list = new ArrayList<>();
    }
    
    public void push(int value) {
        if (this.size == 0) {
            this.minStack.push(value);
        } else if (!this.minStack.isEmpty() && this.minStack.peek() >= value) {
            this.minStack.push(value);
        }

        if (this.list.size() == size) {
            this.list.add(value);
            this.ptr++;
        } else {
            this.list.set(++ptr, value);
        }
        this.size++;
    }
    
    public void pop() {
        if (this.list.get(ptr).equals(this.minStack.peek())) {
            this.minStack.pop();
        }
        this.size--;
        this.ptr--;
    }
    
    public int top() {
        return this.list.get(ptr);        
    }
    
    public int getMin() {
        return this.minStack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */