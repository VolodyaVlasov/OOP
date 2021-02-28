package com.company;

public abstract class AbstractPowerSetFromHashTable extends AbstractHashTable<String>{
    public static final int INTERSECTION_OK = OK;  // метод отработал корректно
    public static final int INTERSECTION_ERR = ERR; // одно или оба из множеств пустые

    public static final int UNION_OK = OK;  // метод отработал корректно
    public static final int UNION_ERR = ERR; // одно или оба из множеств пустые

    public static final int DIFFERENCE_OK = OK;  // метод отработал корректно
    public static final int DIFFERENCE_ERR = ERR; // одно или оба из множеств пустые

    public static final int IS_SUBSET_OK = OK;  // метод отработал корректно
    public static final int IS_SUBSET_ERR = ERR; // одно или оба из множеств пустые

    //конструктор
    public abstract PowerSet PowerSet(int max);

    //команды:
    //предусловие: значение отсутствует в множестве и лимит значений не превышен
    //постусловие: значение добавлено
    public abstract void add(String value);

    //предусловие: можества не пустые
    public abstract PowerSet intersection(PowerSet set);

    //предусловие: можества не пустые и сумма размеров обоих множеств меньше максимального количесва значений
    public abstract PowerSet union(PowerSet set);

    //предусловие: можества не пустые
    public abstract PowerSet difference(PowerSet set);

    //предусловие: можества не пустые
    public abstract boolean isSubset(PowerSet set);

    //дополнительные запросы:

    public abstract int getAddStatus();

    public abstract int getIntersectionStatus();

    public abstract int getUnionStatus();

    public abstract int getDifferenceStatus();

    public abstract int getIsSubsetStatus();

}
