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
        value = new StringBuilder(setDefaultValue(input));
    }

    protected StringBuilder value;

    public Binary add(String input) {
        CharSequence right;
        right = setDefaultValue(input);
        CharSequence left = value;
        StringBuilder sb = new StringBuilder();
        int carrier = 0;
        for (int i = left.length() - 1, j = right.length() - 1;
             i >= 0 || j >= 0;
             i--, j--) {
            int a = i < 0 ? 0 : left.charAt(i) == '1' ? 1 : 0;
            int b = j < 0 ? 0 : right.charAt(j) == '1' ? 1 : 0;
            int current = a ^ b ^ carrier;
            sb.insert(0, current);
            carrier = a + b + carrier >= 2 ? 1 : 0;
        }
        if (carrier == 1)
            sb.insert(0, '1');
        value = sb;
        return this;
    }

    private CharSequence setDefaultValue(String input) {
        CharSequence charSequence;
        if (StringUtils.isNotEmpty(input))
            charSequence = input;
        else
            charSequence = "0";
        return charSequence;
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
