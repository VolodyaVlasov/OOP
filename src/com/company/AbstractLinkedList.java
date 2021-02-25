package com.company;

public abstract class AbstractLinkedList<T> {
    public static final int NIL = 0;
    public static final int OK = 1;
    public static final int ERR = 2;

    public static final int HEAD_NIL = NIL; // head еще не вызывалась
    public static final int HEAD_OK = OK;   // курсор установлен на head
    public static final int HEAD_ERR = ERR; // список пуст

    public static final int TAIL_NIL = NIL; // tail еще не вызывалась
    public static final int TAIL_OK = OK;   // курсор установлен на tail
    public static final int TAIL_ERR = ERR; // список пуст

    public static final int RIGHT_NIL = NIL; // right еще не вызывалась
    public static final int RIGHT_OK = OK;   // курсор сдвинут вправо
    public static final int RIGHT_ERR = ERR; // список пуст или курсор указывает на хвост

    public static final int PUT_RIGHT_NIL = NIL; // putRight еще не вызывалась
    public static final int PUT_RIGHT_OK = OK;   // значение добавлено
    public static final int PUT_RIGHT_ERR = ERR; // список пуст

    public static final int PUT_LEFT_NIL = NIL; // putLeft еще не вызывалась
    public static final int PUT_LEFT_OK = OK;   // значение добавлено
    public static final int PUT_LEFT_ERR = ERR; // список пуст

    public static final int REPLACE_NIL = NIL; // replace еще не вызывалась
    public static final int REPLACE_OK = OK;   // значение заменено
    public static final int REPLACE_ERR = ERR; // список пустой

    public static final int REMOVE_NIL = NIL; // remove еще не вызывалась
    public static final int REMOVE_OK = OK;   // значение удалено
    public static final int REMOVE_ERR = ERR; // список пустой

    public static final int PUT_FIND_NIL = NIL; // find еще не вызывалась
    public static final int PUT_FIND_OK = OK;   // курсор установлен
    public static final int PUT_FIND_ERR = ERR; // узел не найден

    public static final int PUT_GET_NIL = NIL; // get еще не вызывалась
    public static final int PUT_GET_OK = OK;   // метод отработал успешно
    public static final int PUT_GET_ERR = ERR; // список пуст

    //конструктор:
    public AbstractLinkedList(){}

    //команды:

    // предусловие: список не пустой
    // постусловие: курсор указывает на первый узел в списке
    public abstract void head();

    // предусловие: список не пустой
    // постусловие: курсор указывает на последний узел в списке
    public abstract void tail();

    // предусловие: список не пустой и курсор не указывает на хвост
    // постусловие: курсор сдвинется вправо
    public abstract void right();

    // предусловие: список не пустой
    // постусловие: справа от курсора добавленно новое значение
    public abstract void putRight(T value);

    // предусловие: список не пустой
    // постусловие: слева от курсора добавленно новое значение
    public abstract void putLeft(T value);

    //предусловие: список не пустой
    // постусловие: значение на которое указывает курсор удалено,
    // постусловие: курсор сместиться на правый узел, если его нет на левый
    public abstract void remove();

    // постусловие: из списка удалятся все узлы
    public abstract void clear();

    // постусловие: добавлен новый узел в хвост списка
    public abstract void addTail(T value);

    // предусловие: список не пустой
    // постусловие: заменено значение узла на который указывает курсор
    public abstract void replace(T value);

    // постусловие: курсор указывает на узел с искомым значением, если он есть
    public abstract void find(T value);

    // постусловие: из листа удалены все узлы с заданным значением
    public abstract void removeAll(T value);

    //запросы:

    // предусловие: список не пустой
    public abstract T get();

    public abstract int size();

    public abstract boolean isHead();

    public abstract boolean isTail();

    public abstract boolean isValue();

    // дополнительные запросы:
    public abstract int getHeadStatus();

    public abstract int getTailStatus();

    public abstract int getRightStatus();

    public abstract int getPutRightStatus();

    public abstract int getPutLeftStatus();

    public abstract int getReplaceStatus();

    public abstract int getRemoveStatus();

    public abstract int getFindStatus();

    public abstract int getGetStatus();
}
