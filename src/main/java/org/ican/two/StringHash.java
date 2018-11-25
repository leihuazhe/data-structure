package org.ican.two;

/**
 * @author <a href=mailto:leihuazhe@gmail.com>maple</a>
 * @since 2018-11-23 2:25 PM
 */
public class StringHash {

    public static void main(String[] args) {
        String storeId = "11729200";
        int i = storeId.hashCode();
        int p = i % 3;
        System.out.println(i);

        System.out.println("p: " + p);
    }
}
