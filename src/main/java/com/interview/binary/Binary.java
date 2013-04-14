package com.interview.binary;

import net.jcip.annotations.NotThreadSafe;
import org.apache.commons.lang3.StringUtils;

/**
 * This problem asked by @see <a href="https://github.com/JingtingWang"> Jingting Wang</a> from
 * @see <a  href="https://www.stypi.com/xillltmv">stypi</a>
 * Do a binary bitAdd without any Java internal operations.  For example, "1010111" + "11110"
 * Giving you two strings, calculate the sum.  Return value is {@link String}.
 */
@NotThreadSafe
public class Binary {
    public Binary(String input) {
        value = String.valueOf(setDefaultValue(input));
    }

    protected volatile String value;

    public Binary add(String input) {
        char[] right;
        right = setDefaultValue(input);
        char[] left = value.toCharArray();
        StringBuilder sb = new StringBuilder();
        int carrier = 0;
        for (int i = left.length - 1, j = right.length - 1;
             i >= 0 || j >= 0;
             i--, j--) {
            int a = i < 0 ? 0 : left[i] == '1' ? 1 : 0;
            int b = j < 0 ? 0 : right[j] == '1' ? 1 : 0;
            int current = a ^ b ^ carrier;
            sb.insert(0, current);
            carrier = a + b + carrier >= 2 ? 1 : 0;
        }
        if (carrier == 1)
            sb.insert(0, '1');
        value = sb.toString();
        return this;
    }

    private char[] setDefaultValue(String input) {
        char[] right;
        if (StringUtils.isNotEmpty(input))
            right = input.toCharArray();
        else
            right = new char[]{'0'};
        return right;
    }

    @Override
    public String toString() {
        return value;
    }
}
