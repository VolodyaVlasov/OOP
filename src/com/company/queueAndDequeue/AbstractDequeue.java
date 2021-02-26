package com.company.queueAndDequeue;

public abstract class AbstractDequeue<T> extends AbstractParentQueue<T> {
    //команды:

    // постусловие: элемент добавлен в начало очереди
    public abstract void pushFirst(T value);

    // предусловие: очередь не пустая
    // постусловие: элемент удален с конца очереди
    public abstract void popLast();

    //запросы:

    // предусловие: очередь не пустая
    public abstract T peekLast();

    // дополнительные запросы
    public abstract int getPopLastStatus();
    public abstract int getPeekLastStatus();
}
