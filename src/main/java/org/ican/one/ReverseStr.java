package org.ican.one;

/**
 * @author <a href=mailto:leihuazhe@gmail.com>maple</a>
 * @since 2018-11-22 9:27 AM
 */
public class ReverseStr {

    public char[] reverseStr(char[] arr, int start, int end) {
        reverse(arr, start, end);
        int p0 = 0, p1 = 0;

        while (p0 < end) {

            if (Character.isWhitespace(arr[p0])) {
                p0++;
                p1++;
            } else if (Character.isWhitespace(arr[p1]) || p1 == end) {
                arr = reverse(arr, p0, p1 - 1);
                p0 = p1++;
            } else {
                p1++;
            }
        }
        return arr;
    }

    public char[] reverse(char[] arr, int start, int end) {
        while (start < end) {
            char tmp = arr[start];
            arr[start] = arr[end];
            arr[end] = tmp;
            start++;
            end--;
        }

        return arr;
    }

    public static void main(String[] args) {
        String str = "hello world";
        ReverseStr reverse = new ReverseStr();

        char[] reverse1 = reverse.reverseStr(str.toCharArray(), 0, str.length() - 1);

        String s = new String(reverse1);

        System.out.println(s);
    }


}
