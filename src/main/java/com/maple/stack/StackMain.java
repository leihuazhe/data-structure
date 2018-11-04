package com.maple.stack;

import com.maple.array.Array;

/**
 * @author <a href=mailto:leihuazhe@gmail.com>maple</a>
 * @since 2018-11-04 9:20 PM
 */
public class StackMain {
    public static void main(String[] args) {
        ArrayStack<Integer> stack = new ArrayStack<>();

        for (int i = 0; i < 5; i++) {
            stack.push(i);
            System.out.println(stack);
        }
        stack.pop();

        System.out.println(stack);
    }

}
