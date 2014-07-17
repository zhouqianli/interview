package leetcode.ch02;

/**
 * Created by Zhong on 2014/7/17.
 */
public class ArrayEx {

    /**
     * @param input the input array with sorted elements
     * @param <T>   input element type
     * @return the length of new array
     * @see <a href="https://oj.leetcode.com/problems/remove-duplicates-from-sorted-array/">leetcode OJ</a>
     * <p>
     * Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.
     * Do not allocate extra space for another array, you must do this in place with constant memory.
     * <p>
     * For example,
     * Given input array A = [1,1,2],
     * <p>
     * Your function should return length = 2, and A is now [1,2].
     */
    public static <T> int removeDuplicatesFromSortedArray(T[] input) {
        if (input.length < 2)
            return input.length;

        int result = 0;
        for (int i = 1; i < input.length; i++)
            if (!input[result].equals(input[i]))
                input[++result] = input[i];
        return result + 1;
    }

    /**
     * @param input the input array with sorted elements
     * @param n     duplicate counter, indicate how many dup number allowed
     * @param <T>   input element type
     * @return the length of new array
     * @see <a href="https://oj.leetcode.com/problems/remove-duplicates-from-sorted-array/">leetcode OJ</a>
     * Follow up for ”Remove Duplicates”: What if duplicates are allowed at most twice?
     * For example, Given sorted array A = [1,1,1,2,2,3],
     * Your function should return length = 5, and A is now [1,1,2,2,3]
     */
    public static <T> int removeDuplicatesFromSortedArrayII(T[] input, int n) {
        if (input.length < 2)
            return input.length;
        int result = 0, counter = 1;
        for (int i = 1; i < input.length; i++)
            if (input[result].equals(input[i])) {
                if (++counter <= n)
                    // this is a main difference compare to part I
                    // need move element even they match
                    input[++result] = input[i];
            } else {
                counter = 1;
                input[++result] = input[i];
            }
        return result + 1;
    }

}
