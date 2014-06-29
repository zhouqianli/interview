package cict.ch01;

import java.security.InvalidParameterException;

/**
 * Implement an algorithm to determine if a string has
 * all unique characters.  What if you cannot use additional
 * data structures?
 */
public class Q1_1 {
    public static boolean isUniqueChars(CharSequence input) {
        char[] value = new char[256];
        boolean isUnique = true;
        verify(input);
        for (int i = 0; i < input.length(); ++i) {
            int c = (int) input.charAt(i);
            ++value[c];
            if (value[c] > 1) {
                isUnique = false;
                break;
            }
        }
        return isUnique;
    }

    private static void verify(CharSequence input) {
        if (input == null || input.equals(""))
            throw new InvalidParameterException();
    }

    public static boolean isUniqueChars_NoAdditionalData(CharSequence input) {
        boolean isUnique = true;
        for (int i = 0; i < input.length() - 1; ++i) {
            for (int j = i + 1; j < input.length(); ++j)
                if (input.charAt(i) == input.charAt(j)) {
                    isUnique = false;
                    break;
                }
        }
        return isUnique;
    }
}
