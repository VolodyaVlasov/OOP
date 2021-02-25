package com.company;

import java.util.LinkedList;

public class Queue<T> extends AbstractQueue<T> {
    private int size;
    private final LinkedList<T> queue;
    private int popStatus;
    private int peekStatus;

    public Queue() {
        size = 0;
        queue = new LinkedList<>();
        popStatus = 0;
        peekStatus = 0;
    }

    @Override
    public void push(final T value) {
        queue.addLast(value);
        size++;
    }

    @Override
    public void pop() {
        if (size > 0) {
            queue.removeFirst();
            size--;
            popStatus = OK;
        } else {
            popStatus = ERR;
        }
    }

    @Override
    public T peek() {
        T value;
        if(size > 0) {
            value = queue.getFirst();
            peekStatus = OK;
        } else {
            value = null;
            peekStatus = ERR;
        }
        return value;
    }

    @Override
    public int size() {
        return size;
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
