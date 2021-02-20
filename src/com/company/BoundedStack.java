package com.company;

public class BoundedStack<T> extends AbstractBoundedStack {
    private final int length;
    private T[] stack;
    private int index;
    private int peekStatus;
    private int popStatus;
    private int pushStatus;

    BoundedStack() {
        length = 32;
        stack = (T[]) new Object[length];
        index = -1;
        peekStatus = PEEK_NIL;
        popStatus = POP_NIL;
        pushStatus = PUSH_NIL;
    }

    BoundedStack(final int length) {
        this.length = length;
        stack = (T[]) new Object[length];
        index = -1;
        peekStatus = PEEK_NIL;
        popStatus = POP_NIL;
        pushStatus = PUSH_NIL;
    }

    @Override
    public void push(final Object value) {
        if (index < length) {
            stack[index++] = (T) value;
            pushStatus = PUSH_OK;
        } else {
            pushStatus = PUSH_ERR;
        }
    }

    @Override
    public void pop() {
        if (index >= 0) {
            stack[index--] = null;
            popStatus = POP_OK;
        } else {
            popStatus = POP_ERR;
        }
    }

    @Override
    public void clear() {
        stack = (T[]) new Object[length];
    }

    @Override
    public T peek() {
        T result;
        if (index >= 0) {
            result = stack[index];
            peekStatus = PEEK_OK;
        } else {
            result = null;
            peekStatus = PEEK_ERR;
        }
        return result;
    }

    @Override
    public int size() {
        return index + 1;
    }

    @Override
    public int getPopStatus() {
        return popStatus;
    }

    @Override
    public int getPeekStatus() {
        return peekStatus;
    }
}
