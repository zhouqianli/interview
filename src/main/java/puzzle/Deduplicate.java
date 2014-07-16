package puzzle;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by Zhong on 2014/7/16.
 */
public class Deduplicate {

    /**
     * Remove duplication brace in a expression.  For example, "((a+b))*c" => "(a+b)*c"
     *
     * @param input
     * @return
     */
    public static String removeDuplicateBrace(String input) throws Exception {
        StringBuilder result = new StringBuilder();
        ArrayList<Integer> marker = new ArrayList<>();
        final char LEFT_BRACE = '(';
        final char RIGHT_BRACE = ')';
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == LEFT_BRACE) {
                stack.push(i);
                continue;
            }
            if (i < input.length() - 1)
                if (input.charAt(i) == RIGHT_BRACE
                        && input.charAt(i + 1) == RIGHT_BRACE
                        && stack.peek() - 1 == stack.get(stack.size() - 2)
                        ) {
                    marker.add(stack.pop());
                    marker.add(i);
                    continue;
                }
            if (input.charAt(i) == RIGHT_BRACE)
                stack.pop();
        }
        if (!stack.isEmpty())
            throw new Exception("Braces are not paired.");
        for (int i = 0; i < input.length(); i++) {
            if (!marker.contains(i))
                result.append(input.charAt(i));
        }
        return result.toString();
    }

}
