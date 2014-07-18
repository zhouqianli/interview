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

        int j = 1;
        for (int i = 1; i < input.length; i++)
            if (!input[i].equals(input[j - 1]))
                input[j++] = input[i];
        return j;
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
        if (input.length < n)
            return input.length;
        int j = n;
        for (int i = j; i < input.length; i++)
            if (!input[i].equals(input[j - n]))
                input[j++] = input[i];
        return j;
    }


    /**
     * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
     * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
     * You are given a target value to search. If found in the array return its index, otherwise return -1.
     * You may assume no duplicate exists in the array.
     *
     * @param input the rotated sorted array
     * @param item  which is we searched for
     * @param <T>   element type
     * @return -1 if not found, index if found
     * @see <a href="https://oj.leetcode.com/problems/search-in-rotated-sorted-array/">OJ</a>
     * @see <a href="http://leetcode.com/2010/04/searching-element-in-rotated-array.html">Blog</a>
     */
    public static <T> int searchInRotatedSortedArray(T[] input, T item) {
        final int NOT_FOUND = -1;

        return NOT_FOUND;
    }
}
