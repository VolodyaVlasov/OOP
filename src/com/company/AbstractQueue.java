package com.company;

public abstract class AbstractQueue<T> {
    public static final int NIL = 0; // метод еще не вызылся
    public static final int OK = 1;
    public static final int ERR = 2;

    public static final int POP_OK = OK;  // последняя pop() отработала нормально
    public static final int POP_ERR = ERR; // очередь пустая

    public static final int PEEK_OK = OK;  // последняя peek() вернула корректное значение
    public static final int PEEK_ERR = ERR; // очередь пустая

    // конструктор
    public AbstractQueue() {
    }

    // команды:

    // постусловие: элемент добавлен в конец очереди
    public abstract void push(T value);

    // предусловие: очередь не пустая
    // постусловие: элемент удален с начала очереди
    public abstract void pop();

    // запросы:

    // предусловие: очередь не пустая
    public abstract T peek();

    public abstract int size();

    // дополнительные запросы
    public abstract int getPopStatus();

    public abstract int getPeekStatus();
}
