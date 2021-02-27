package com.company;

public abstract class AbstractPowerSet {
    public static final int NIL = 0; // метод еще не вызывался
    public static final int OK = 1;
    public static final int ERR = 2;

    public static final int ADD_OK = OK;  // значение добавлено
    public static final int ADD_ERR = ERR; // значение не добавлено

    public static final int REMOVE_OK = OK;  // значение удалено
    public static final int REMOVE_ERR = ERR; // значение отсутствует

    public static final int INTERSECTION_OK = OK;  // метод отработал корректно
    public static final int INTERSECTION_ERR = ERR; // одно из множеств пустое

    public static final int UNION_OK = OK;  // метод отработал корректно
    public static final int UNION_ERR = ERR; // одно из множеств пустое

    public static final int DIFFERENCE_OK = OK;  // метод отработал корректно
    public static final int DIFFERENCE_ERR = ERR; // одно из множеств пустое

    public static final int IS_SUBSET_OK = OK;  // метод отработал корректно
    public static final int IS_SUBSET_ERR = ERR; // одно из множеств пустое

    //команды:

    //предусловие: значение отсутствует в множестве
    //постусловие: значение добавлено
    public abstract void add(String value);

    //предусловие: значение присутствует в множестве
    //постусловие: значение удалено
    public abstract void remove(String value);

    //запросы:
    public abstract boolean check(String value);

    //предусловие: можества не пустые
    public abstract AbstractPowerSet intersection(AbstractPowerSet set);

    //предусловие: можества не пустые
    public abstract AbstractPowerSet union(AbstractPowerSet set);

    //предусловие: можества не пустые
    public abstract AbstractPowerSet difference(AbstractPowerSet set);

    //предусловие: можества не пустые
    public abstract AbstractPowerSet isSubset(AbstractPowerSet set);

    //дополнительные запросы:

    public abstract int getAddStatus();

    public abstract int getRemoveStatus();

    public abstract int getIntersectionStatus();

    public abstract int getUnionStatus();

    public abstract int getDifferenceStatus();

    public abstract int getIsSubsetStatus();

}
