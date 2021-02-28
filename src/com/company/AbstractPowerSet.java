package com.company;

public abstract class AbstractPowerSet<T> {
    public static final int NIL = 0; // метод еще не вызывался
    public static final int OK = 1;
    public static final int ERR = 2;

    public static final int ADD_OK = OK;  // значение добавлено
    public static final int ADD_ERR = ERR; // значение не добавлено

    public static final int REMOVE_OK = OK;  // значение удалено
    public static final int REMOVE_ERR = ERR; // значение отсутствует

    //команды:

    //предусловие: значение отсутствует в множестве
    //постусловие: значение добавлено
    public abstract void add(T value);

    //предусловие: значение присутствует в множестве
    //постусловие: значение удалено
    public abstract void remove(T value);

    //запросы:
    public abstract int size();

    public abstract boolean check(T value);

    //предусловие: можества не пустые
    public abstract AbstractPowerSet<T>  intersection(AbstractPowerSet<T> set);

    //предусловие: можества не пустые
    public abstract AbstractPowerSet<T>  union(AbstractPowerSet<T>  set);

    //предусловие: можества не пустые
    public abstract AbstractPowerSet<T>  difference(AbstractPowerSet<T>  set);

    //предусловие: можества не пустые
    public abstract boolean isSubset(AbstractPowerSet<T>  set);

    //дополнительные запросы:

    public abstract int getAddStatus();

    public abstract int getRemoveStatus();

}
