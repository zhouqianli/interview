package cict.ch01;

import java.security.InvalidParameterException;

/**
 * Implement a function reverse(CharSequence str)
 */
public enum Q1_2 {
    INSTANCE;

    public String reverse(String input) {
        if (input == null) return null;
        StringBuilder sb = new StringBuilder(input.length());
        for (int i = input.length() - 1; i >= 0; --i)
            sb.append(input.charAt(i));
        return sb.toString();
    }

}
