package com.company;

import javax.sql.PooledConnection;

public class PowerSet extends AbstractPowerSet {
    private int length;
    private Node[] storage;
    private int size;
    private int addStatus;
    private int removeStatus;
    private int intersectionStatus;
    private int unionStatus;
    private int differenceStatus;
    private int isSubsetStatus;

    public PowerSet() {
        this(16);
    }

    public PowerSet(int length) {
        size = 0;
        this.length = length;
        storage = new Node[length];
        addStatus = 0;
        removeStatus = 0;
        intersectionStatus = 0;
        unionStatus = 0;
        differenceStatus = 0;
        isSubsetStatus = 0;
    }


    @Override
    public void add(String value) {
        int index = findBasket(value);
        if (storage[index] == null) {
            storage[index] = new Node(value);
        } else {
            Node start = storage[index];
            Node prev = null;
            while (start != null) {
                if (start.value.equals(value)) {
                    addStatus = ERR;
                    return;
                }
                prev = start;
                start = start.next;
            }
            prev.next = new Node(value);
        }
        size++;
        addStatus = OK;
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
    public int size() {
        return size;
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
    public PowerSet intersection(PowerSet set) {
        PowerSet powerSet = new PowerSet(size);
        if (size == 0 || set.size() == 0) {
            intersectionStatus = ERR;
        } else {
            for (int i = 0; i < length; i++) {
                Node start = storage[i];
                while (start != null) {
                    if (set.check(start.value)) {
                        powerSet.add(start.value);
                    }
                    start = start.next;
                }
            }
            intersectionStatus = OK;
        }
        return powerSet;
    }

    @Override
    public PowerSet union(PowerSet set) {
        PowerSet powerSet = new PowerSet(size + set.size);
        if (size == 0 || set.size() == 0) {
            unionStatus = ERR;
        } else {
            for (int i = 0; i < length; i++) {
                Node start = storage[i];
                while (start != null) {
                    powerSet.add(start.value);
                    start = start.next;
                }
            }
            for (String s : set.toArray()) {
                powerSet.add(s);
            }
            unionStatus = OK;
        }
        return powerSet;
    }

    @Override
    public PowerSet difference(PowerSet set) {
        PowerSet powerSet = new PowerSet();
        if (size == 0 || set.size() == 0) {
            differenceStatus = ERR;
        } else {
            for (int i = 0; i < length; i++) {
                Node start = storage[i];
                while (start != null) {
                    if (!set.check(start.value)) {
                        powerSet.add(start.value);
                    }
                    start = start.next;
                }
            }
            differenceStatus = OK;
        }
        return powerSet;
    }

    @Override
    public boolean isSubset(PowerSet set) {
        boolean answer = true;
        if (size == 0 || set.size() == 0) {
            isSubsetStatus = ERR;
            answer = false;
        } else {
            for (int i = 0; i < length; i++) {
                Node start = storage[i];
                while (start != null) {
                    if (!set.check(start.value)) {
                        answer = false;
                        break;
                    }
                    start = start.next;
                }
            }
            isSubsetStatus = OK;
        }
        return answer;
    }

    @Override
    public int getAddStatus() {
        return addStatus;
    }

    @Override
    public int getRemoveStatus() {
        return removeStatus;
    }

    @Override
    public int getIntersectionStatus() {
        return intersectionStatus;
    }

    @Override
    public int getUnionStatus() {
        return unionStatus;
    }

    @Override
    public int getDifferenceStatus() {
        return differenceStatus;
    }

    @Override
    public int getIsSubsetStatus() {
        return isSubsetStatus;
    }

    public int findBasket(String value) {
        return value.hashCode() % length;
    }

    private void increaseArray() {
        length = length * 3 / 2 + 1;
        Node[] temp = storage;
        storage = new Node[length];
        for (Node node : temp) {
            while (node != null) {
                add(node.value);
                node = node.next;
            }
        }
    }

    public String[] toArray() {
        String[] array = new String[size];
        int index = 0;
        for (Node node : storage) {
            while (node != null) {
                array[index++] = node.value;
                node = node.next;
            }
        }
        return array;
    }

    private static class Node {
        String value;
        Node next;

        public Node(String value) {
            this.value = value;
        }
    }
}
