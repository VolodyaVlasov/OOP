package com.company;

public class PowerSet extends AbstractPowerSet {
    private int length;
    private Node[] storage;
    private int size;
    private int addStatus;
    private int removeStatus;


    @Override
    public void add(String value) {
        int index = findBasket(value);
        Node start = storage[index];
        Node prev = null;
        while (start != null) {
            if (start.value.equals(value)) {
                break;
            }
            prev = start;
            start = start.next;
        }
        if (start == null) {
            start = new Node(value);
            if (prev != null) {
                prev = start;
            }
            size++;
            addStatus = OK;
            if (size > length) {
                increaseArray();
            }
        } else {
            addStatus = ERR;
        }
    }

    @Override
    public void remove(String value) {
        int index = findBasket(value);
        boolean status = false;
        if (storage[index] != null) {
            if (storage[index].value.equals(value)) {
                storage[index] = storage[index].next;
                size--;
                status = true;
            } else {
                Node start = storage[index].next;
                Node prev = storage[index];
                while (start != null) {
                    if (start.value.equals(value)) {
                        prev.next = start.next;
                        size--;
                        status = true;
                        break;
                    }
                    prev = start;
                    start = start.next;
                }
            }
        }
        removeStatus = status ? OK : ERR;
    }

    @Override
    public boolean check(String value) {
       int index = findBasket(value);
       Node start = storage[index];
       while (start != null) {
           if (start.value.equals(value)) {
               return true;
           }
           start = start.next;
       }
       return false;
    }

    @Override
    public AbstractPowerSet intersection(AbstractPowerSet set) {
        return null;
    }

    @Override
    public AbstractPowerSet union(AbstractPowerSet set) {
        return null;
    }

    @Override
    public AbstractPowerSet difference(AbstractPowerSet set) {
        return null;
    }

    @Override
    public AbstractPowerSet isSubset(AbstractPowerSet set) {
        return null;
    }

    @Override
    public int getAddStatus() {
        return 0;
    }

    @Override
    public int getRemoveStatus() {
        return 0;
    }

    @Override
    public int getIntersectionStatus() {
        return 0;
    }

    @Override
    public int getUnionStatus() {
        return 0;
    }

    @Override
    public int getDifferenceStatus() {
        return 0;
    }

    @Override
    public int getIsSubsetStatus() {
        return 0;
    }

    public int findBasket(String value) {
        return value.hashCode() % length;
    }

    private static class Node {
        String value;
        Node next;

        public Node(String value) {
            this.value = value;
        }
    }
}
