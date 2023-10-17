package study;

import java.util.Stack;

public class MinStack extends Stack<Integer> {

    private final Stack<Integer> minStack;

    public MinStack() {
        minStack = new Stack<>();
    }

    @Override
    public Integer push(Integer item) {
        if (isEmpty() || item <= minStack.peek()) {
            minStack.push(item);
        }
        return super.push(item);
    }

    @Override
    public synchronized Integer pop() {
        int item = super.pop();
        if (item == minStack.peek()) {
            minStack.pop();
        }
        return item;
    }

    public Integer min() {
        if (minStack.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return minStack.peek();
    }

}