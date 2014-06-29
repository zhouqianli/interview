package cict.ch01;

/**
 * Given two strings, write a method to decide if one is
 * a permutation of the other.
 */
public class Q1_3 {
    public static boolean isPermutation(String a, String b) {
        if (a == null || b == null)
            return false;

        if (a.length() != b.length())
            return false;

        int[] value = new int[256];

        for (char c : a.toCharArray())
            value[c]++;
        for (char c : b.toCharArray())
            if (--value[c] < 0)
                return false;

        return true;
    }
}
