import org.junit.Test;

import java.util.Stack;

import static junit.framework.Assert.assertEquals;

/**
 * https://leetcode.com/problems/min-stack/
 */
public class MinStack {

    class StackItem {
        int value;
        int min;
        StackItem(int value, int min) {
            this.value = value;
            this.min = min;
        }
    }

    Stack<StackItem> stack = new Stack<>();

    public void push(int x) {
        if (stack.isEmpty()) {
            stack.push(new StackItem(x, x));
        } else {
            int min = stack.peek().min;
            if (x < min) {
                min = x;
            }
            stack.push(new StackItem(x, min));
        }
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek().value;
    }

    public int getMin() {
        return stack.peek().min;
    }


    @Test
    public void test() {
        MinStack minStack = new MinStack();
        minStack.push(10);
        assertEquals(10, minStack.getMin());
        assertEquals(10, minStack.top());
        minStack.push(20);
        assertEquals(10, minStack.getMin());
        assertEquals(20, minStack.top());
        minStack.push(5);
        assertEquals(5, minStack.getMin());
        assertEquals(5, minStack.top());
    }

}
