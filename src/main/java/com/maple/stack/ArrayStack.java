package com.maple.stack;

import com.maple.array.Array;

/**
 * @author <a href=mailto:leihuazhe@gmail.com>maple</a>
 * @since 2018-11-04 9:20 PM
 */
public class ArrayStack<E> implements Stack<E> {
    /**
     * 动态数组
     */
    private Array<E> array;

    public ArrayStack(int capacity) {
        array = new Array<E>(capacity);
    }

    public ArrayStack() {
        array = new Array<E>();
    }

    /**
     * push
     */
    @Override
    public void push(E e) {
        array.addLast(e);
    }

    /**
     * pop
     */
    @Override
    public E pop() {
        return array.removeLast();
    }

    /**
     * peek
     */
    @Override
    public E peek() {
        return array.getLast();
    }

    @Override
    public int getSize() {
        return array.size();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    public int getCapacity() {
        return array.getCapacity();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Stack: [");
        for (int i = 0; i < array.size(); i++) {
            res.append(array.get(i));
            if (i != array.size() - 1) {
                res.append(", ");
            }
        }
        res.append("] Top");
        return res.toString();
    }
}
