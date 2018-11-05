package com.maple.queue;

import com.maple.stack.ArrayStack;

/**
 * @author <a href=mailto:leihuazhe@gmail.com>maple</a>
 * @since 2018-11-04 9:20 PM
 */
public class QueueMain {
    public static void main(String[] args) {
        stressArrayQueue();
        stressLoopQueue();
    }



    public static void arrayQueue() {
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

    public static void stressArrayQueue() {
        Queue<Integer> queue = new ArrayQueue<>();
        long begin = System.currentTimeMillis();
        for (int i = 0; i < 100000000; i++) {
            queue.enqueue(i);
//            System.out.println(queue);
        }
        System.out.println("array enqueue耗时: " + (System.currentTimeMillis() - begin) + "ms");

        long begin2 = System.currentTimeMillis();
        Integer dequeue = queue.dequeue();
        System.out.println("array dequeue耗时: " + (System.currentTimeMillis() - begin2) + "ms " + dequeue);


    }

    public static void stressLoopQueue() {
        Queue<Integer> queue = new LoopQueue<>();
        long begin = System.currentTimeMillis();
        for (int i = 0; i < 100000000; i++) {
            queue.enqueue(i);
//            System.out.println(queue);
        }
        System.out.println("loop enqueue耗时: " + (System.currentTimeMillis() - begin) + "ms");

        long begin2 = System.currentTimeMillis();
        Integer dequeue = queue.dequeue();
        System.out.println("loop dequeue耗时: " + (System.currentTimeMillis() - begin2) + "ms " + dequeue);


    }

    public static void loopQueue() {
        Queue<Integer> queue = new LoopQueue<>();
        for (int i = 0; i < 15; i++) {
            queue.enqueue(i);
            System.out.println(queue);
            if (i % 3 == 2) {
                //如果100万的队列,每次出队时间会很长
                queue.dequeue();
                System.out.println(queue);
            }
        }

    }


}
