package com.company;

public abstract class AbstractBoundedStack<T> {
    public static final int POP_NIL = 0; // pop() ещё не вызывалась
    public static final int POP_OK = 1;  // последняя pop() отработала нормально
    public static final int POP_ERR = 2; // стек пуст

    public static final int PEEK_NIL = 0; // peek() ещё не вызывалась
    public static final int PEEK_OK = 1;  // последняя peek() вернула корректное значение
    public static final int PEEK_ERR = 2; // стек пуст

    public static final int PUSH_NIL = 0; // push() ещё не вызывалась
    public static final int PUSH_OK = 1;  // последняя push() добавила значение
    public static final int PUSH_ERR = 2; // стек переполнен

    //конструктор
    // public BoundedStack<T> BoundedStack(int length);
    // команды:

    // предусловие: стек не заполнен
    // постусловие: в стек добавлено новое значение
    public abstract void push(final T value);

    // предусловие: стек пустой
    // постусловие: из стека удалён верхний элемент
    public abstract void pop();

    // постусловие: из стека удалятся все значения
    public abstract void clear();


    // запросы:

    // предусловие: стек не пустой
    public abstract T peek();

    public abstract int size();

    // дополнительные запросы:
    public abstract int getPopStatus(); // возвращается значение POP

    public abstract int getPeekStatus(); // возвращается значение PEEL

    public abstract int getPushStatus(); // возвращается значение PUSH
}
