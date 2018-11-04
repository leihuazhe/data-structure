package com.maple.queue;

import com.maple.stack.ArrayStack;

/**
 * @author <a href=mailto:leihuazhe@gmail.com>maple</a>
 * @since 2018-11-04 9:20 PM
 */
public class QueueMain {
    public static void main(String[] args) {
        stress();
        Queue<Integer> queue = new ArrayQueue<>();

        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
            System.out.println(queue);
            if (i % 3 == 2) {
                //如果100万的队列,每次出队时间会很长
                queue.dequeue();
                System.out.println(queue);
            }
        }
    }


    public static void stress() {
        Queue<Integer> queue = new ArrayQueue<>();
        long begin = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            queue.enqueue(i);
//            System.out.println(queue);
        }
        System.out.println("enqueue耗时: " + (System.currentTimeMillis() - begin) + "ms");

        long begin2 = System.currentTimeMillis();
        Integer dequeue = queue.dequeue();
        System.out.println("dequeue耗时: " + (System.currentTimeMillis() - begin) + "ms " + dequeue);


    }

}
