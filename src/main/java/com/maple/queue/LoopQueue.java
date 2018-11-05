package com.maple.queue;

/**
 * 循环队列 实现方式
 * front == tail，表示队列此时没有一个元素，为空。
 * <p>
 * (tail+1)%c == front 队列满 (有意浪费一个空间，以免和队列为空冲突)
 * <p>
 * 入队，tail 向后移动一位。
 * 出队，front 向后移动一位。
 * <p>
 * 当tail 到capacity时，判断 数组开头是否为 front 的指针。否则继续使用之前的位置。
 *
 * @author <a href=mailto:leihuazhe@gmail.com>maple</a>
 * @since 2018-11-04 11:15 PM
 */
@SuppressWarnings("unchecked")
public class LoopQueue<E> implements Queue<E> {
    /**
     * 底层存放容器数组
     */
    private E[] elementData;

    private int front, tail;
    private int size;

    public LoopQueue(int capacity) {
        //循环数组会浪费一个空间
        this.elementData = (E[]) new Object[capacity + 1];
        front = 0;
        tail = 0;
        size = 0;
    }

    public LoopQueue() {
        this(10);
    }


    // -1
    public int getCapacity() {
        return elementData.length - 1;
    }

    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    @Override
    public int getSize() {
        return size;
    }

    /**
     * enqueue
     */
    @Override
    public void enqueue(E e) {
        if ((tail + 1) % elementData.length == front) {
            //data.length与getCapacity 有1的差距
            resize(getCapacity() * 2);
        }
        elementData[tail] = e;
        //循环队列的操作
        tail = (tail + 1) % elementData.length;
        size++;
    }


    /**
     * 出队操作 dequeue
     */
    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Can not dequeue from an empty queue.");
        }
        E ret = elementData[front];
        elementData[front] = null;
        front = (front + 1) % elementData.length;
        size--;
        if (size == getCapacity() / 4 && getCapacity() / 2 != 0) {
            resize(getCapacity() / 2);
        }
        return ret;
    }

    @Override
    public E getFront() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Can not dequeue from an empty queue.");
        }
        return elementData[front];
    }

    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity + 1];

        for (int i = 0; i < size; i++) {
            newData[i] = elementData[(i + front) % elementData.length];
        }
        elementData = newData;
        front = 0;
        tail = size;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Queue: size = ").append(size).append(", capacity: ").append(getCapacity()).append("\n");
        res.append("front [");
        for (int i = front; i != tail; i = (i + 1) % elementData.length) {
            res.append(elementData[i]);
            if ((i + 1) % elementData.length != tail) {
                res.append(", ");
            }
        }
        res.append("] tail");
        return res.toString();
    }


}
