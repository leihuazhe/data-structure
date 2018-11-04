package com.maple.queue;

import com.maple.array.Array;

/**
 * 局限: 数组队列出队 时间复杂度是 O(n) 级别
 *
 * @author <a href=mailto:leihuazhe@gmail.com>maple</a>
 * @since 2018-11-04 10:58 PM
 */
public class ArrayQueue<E> implements Queue<E> {
    private Array<E> array;


    public ArrayQueue(int capacity) {
        this.array = new Array(capacity);
    }

    public ArrayQueue() {
        this.array = new Array();
    }

    @Override
    public void enqueue(E e) {
        array.addLast(e);
    }

    @Override
    public E dequeue() {
        return array.removeFirst();
    }

    @Override
    public E getFront() {
        return array.getFirst();
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
        res.append("Queue: front [");
        for (int i = 0; i < array.size(); i++) {
            res.append(array.get(i));
            if (i != array.size() - 1) {
                res.append(", ");
            }
        }
        res.append("] tail");
        return res.toString();
    }
}
