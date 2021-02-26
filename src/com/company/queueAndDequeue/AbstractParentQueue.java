package com.company.queueAndDequeue;

public abstract class AbstractParentQueue<T> {
    // команды:

    // постусловие: элемент добавлен в конец очереди
    public abstract void pushLast(T value);

    // предусловие: очередь не пустая
    // постусловие: элемент удален с начала очереди
    public abstract void popFirst();

    // запросы:

    // предусловие: очередь не пустая
    public abstract T peekFirst();

    public abstract int size();

    // дополнительные запросы
    public abstract int getPopFirstStatus();
    public abstract int getPeekFirstStatus();

}
