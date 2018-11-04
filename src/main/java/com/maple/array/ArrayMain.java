package com.maple.array;

/**
 * @author <a href=mailto:leihuazhe@gmail.com>maple</a>
 * @since 2018-11-04 5:04 PM
 */
public class ArrayMain {

    public static void main(String[] args) {
        Array<String> array = new Array(20);

        for (int i = 0; i < 10; i++) {
            array.addLast("String: " + i);
        }
        System.out.println(array);
        array.set(0, "15");
        array.addLast("1615");
        System.out.println(array.get(5));

        System.out.println(array);

        array.remove(8);
        array.remove(8);
        array.remove(8);
        System.out.println(array);



    }
}
