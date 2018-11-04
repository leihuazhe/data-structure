package com.maple.stack;

import java.util.Arrays;
import java.util.List;

/**
 * 编译器、路由解析也是自顶向下的解析法则。使用 Stack、进行栈顶的操作。
 *
 * @author <a href=mailto:leihuazhe@gmail.com>maple</a>
 * @since 2018-11-04 9:51 PM
 */
public class Parentheses {
    //    private static String parentheses = "{[]}()";
    private static List<Character> left = Arrays.asList('{', '[', '(');

    public static boolean validate(String parentheses) {
        ArrayStack<Character> stack = new ArrayStack<>();

        int pos = 0;
        while (pos < parentheses.length()) {
            char c = parentheses.charAt(pos);
            if (left.contains(c)) {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                Character topChar = stack.pop();
                if (c == '}' && topChar != '{') {
                    return false;
                }
                if (c == ']' && topChar != '[') {
                    return false;
                }
                if (c == ')' && topChar != '(') {
                    return false;
                }
            }
            pos++;
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        boolean isValid = validate("{[({})]}");

        System.out.println(isValid);
    }


}
