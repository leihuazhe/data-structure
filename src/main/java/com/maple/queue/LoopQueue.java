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
public class LoopQueue<E> implements Queue<E> {
    @Override
    public void enqueue(E e) {

    }

    /**
     * 出队操作
     */
    @Override
    public E dequeue() {
        return null;
    }

    @Override
    public E getFront() {
        return null;
    }

    @Override
    public int getSize() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }
}
