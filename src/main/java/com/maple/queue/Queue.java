package com.maple.queue;

import com.maple.stack.Stack;

/**
 * @author <a href=mailto:leihuazhe@gmail.com>maple</a>
 * @since 2018-11-04 10:55 PM
 */
public interface Queue<E> {
    /**
     * 从队尾 入队   {@link com.maple.stack.Stack#push(Object)}
     * 复杂度 O(1)
     */
    void enqueue(E e);

    /**
     * 从队首 出队  {@link Stack#pop()}
     * 出队操作, 复杂度 O(n)
     * 拿出队首元素后,后面的元素需要往前挪动1位
     */
    E dequeue();

    /**
     * 关心队首的元素，获取队首元素值。  {@link Stack#peek()}
     * 复杂度 O(1)
     */
    E getFront();

    /**
     * 复杂度 O(1)
     *
     * @return
     */
    int getSize();

    /**
     * 复杂度 O(1)
     *
     * @return
     */
    boolean isEmpty();

}
