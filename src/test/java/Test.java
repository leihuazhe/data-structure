import java.util.Stack;

/**
 * @author <a href=mailto:leihuazhe@gmail.com>maple</a>
 * @since 2018-11-04 10:20 PM
 */
public class Test {

    /*public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        int pos = 0;
        while (pos < s.length()) {
            char c = s.charAt(pos);
            if (c == '{' || c == '(' || c == '[') {
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
    }*/
}
