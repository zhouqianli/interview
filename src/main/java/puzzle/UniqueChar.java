package puzzle;

/**
 * @author zhouzh
 */

/*
From: Cracking the Coding Interview 4th
Problem:
Implement an algorithm to determine if a string has all unique characters.
What if you can not use additional data structures?
*/
public class UniqueChar {
    // a String is a CharSequence
    // Using a array to identify if a character already exist
    public static boolean isUnique(CharSequence input) {
        boolean isUnique = true;
        if (input == null) return isUnique;
        // if it is a ANSI string
        int[] counter = new int[256];
        for (int i = 0; i < input.length(); i++) {
            counter[(int) input.charAt(i)]++;
            // Cannot remember how to get ASCII from a Char
            if (counter[(int) input.charAt(i)] > 1) {
                isUnique = false;
                break;
            }
        }
        return isUnique;
    }

    // What if you can not use additional data structures?
    public static boolean noAdditionalStructure(CharSequence input) {
        boolean isUnique = true;
        if (input == null) return isUnique;
        for (int i = 0; i < input.length(); i++) {
            for (int j = i + 1; j < input.length(); j++)
                if (input.charAt(i) == (input.charAt(j))) {
                    isUnique = false;
                    // do not use return for singel input/output interface
                    break;
                }
            if (!isUnique) break;
        }
        return isUnique;
    }
}
