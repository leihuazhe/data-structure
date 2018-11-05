package com.maple.linked;

/**
 * @author <a href=mailto:leihuazhe@gmail.com>maple</a>
 * @since 2018-11-05 11:48 PM
 */
public class LinkedMain {

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();

        for (int i = 0; i < 5; i++) {
            linkedList.addFirst(i);
            System.out.println(linkedList);
        }
        linkedList.add(2, 666);
        System.out.println(linkedList);

        linkedList.remove(3);
        System.out.println(linkedList);


        Integer integer1 = linkedList.removeLast();
        System.out.println(linkedList);

        Integer integer = linkedList.removeFirst();
        System.out.println(linkedList);

    }
}
