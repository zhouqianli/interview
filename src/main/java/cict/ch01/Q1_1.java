package cict.ch01;

import java.security.InvalidParameterException;

/**
 * Implement an algorithm to determine if a string has
 * all unique characters.  What if you cannot use additional
 * data structures?
 */
public enum Q1_1 {
    INSTANCE;

    public boolean isUniqueChars(CharSequence input) {
        int[] value = new int[256];
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

    private void verify(CharSequence input) {
        if (input == null || input.equals(""))
            throw new InvalidParameterException();
    }

    public boolean isUniqueChars_NoAdditionalData(CharSequence input) {
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
