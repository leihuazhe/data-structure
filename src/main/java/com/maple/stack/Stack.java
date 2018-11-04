package com.maple.stack;

/**
 * @author <a href=mailto:leihuazhe@gmail.com>maple</a>
 * @since 2018-11-04 9:19 PM
 */
public interface Stack<E> {
    void push(E e);

    E pop();

    E peek();

    int getSize();

    boolean isEmpty();
}
