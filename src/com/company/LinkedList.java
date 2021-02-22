package com.company;

public abstract class LinkedList<T> {

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

    // предусловие: в списке имеется узел с искомым значением
    // постусловие: курсор указывает на узел с искомым значением
    public abstract void find(T value);

    // постусловие: из листа удалены все узлы с заданным значением
    public abstract void removeAll(T value);

    //запросы:

    // предусловие: список не пустой
    public abstract void get();

    public abstract void size();

    public abstract void isHead();

    public abstract void isTail();

    public abstract void isValue();

    public abstract int getHeadStatus();
    public abstract int getTailStatus();
    public abstract int getRightStatus();
    public abstract int getPutRightStatus();
    public abstract int getPutLeftStatus();
    public abstract int getFindStatus();
    public abstract int getGetStatus();

}
