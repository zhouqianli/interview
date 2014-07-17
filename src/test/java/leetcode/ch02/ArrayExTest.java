package leetcode.ch02;

import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ArrayExTest {

    @Test
    public void testRemoveDuplicatesFromSortedArrayII01() throws Exception {
        Integer[] input = {1, 1, 2};
        Integer[] expected = {1, 1, 2};
        int count = ArrayEx.removeDuplicatesFromSortedArrayII(input, 2);
        Assert.assertEquals(input, expected);
        Assert.assertEquals(count, 3);
    }

    @Test
    public void testRemoveDuplicatesFromSortedArrayII02() throws Exception {
        Integer[] input = {1, 1, 1, 2};
        Integer[] expected = {1, 1, 2, 2};
        int count = ArrayEx.removeDuplicatesFromSortedArrayII(input, 2);
        Assert.assertEquals(input, expected);
        Assert.assertEquals(count, 3);
    }

    @Test
    public void testRemoveDuplicatesFromSortedArrayII03() throws Exception {
        Integer[] input = {1, 2, 2};
        Integer[] expected = {1, 2, 2};
        int count = ArrayEx.removeDuplicatesFromSortedArrayII(input, 2);
        Assert.assertEquals(input, expected);
        Assert.assertEquals(count, 3);
    }

    @Test
    public void testRemoveDuplicatesFromSortedArrayII04() throws Exception {
        Integer[] input = {1, 1, 1, 1, 3, 3};
        Integer[] expected = {1, 1, 3, 3, 3, 3};
        int count = ArrayEx.removeDuplicatesFromSortedArrayII(input, 2);
        Assert.assertEquals(input, expected);
        Assert.assertEquals(count, 4);
    }

    @Test
    public void testRemoveDuplicatesFromSortedArray01() throws Exception {
        Integer[] input = {1, 1, 2};
        Integer[] expected = {1, 2, 2};
        int count = ArrayEx.removeDuplicatesFromSortedArray(input);
        Assert.assertEquals(input, expected);
        Assert.assertEquals(count, 2);
    }

    @Test
    public void testRemoveDuplicatesFromSortedArray02() throws Exception {
        Integer[] input = {1, 1, 1};
        Integer[] expected = {1, 1, 1};
        int count = ArrayEx.removeDuplicatesFromSortedArray(input);
        Assert.assertEquals(input, expected);
        Assert.assertEquals(count, 1);
    }

    @Test
    public void testRemoveDuplicatesFromSortedArray03() throws Exception {
        Integer[] input = {1};
        Integer[] expected = {1};
        int count = ArrayEx.removeDuplicatesFromSortedArray(input);
        Assert.assertEquals(input, expected);
        Assert.assertEquals(count, 1);
    }

    @Test
    public void testRemoveDuplicatesFromSortedArray04() throws Exception {
        Integer[] input = {};
        Integer[] expected = {};
        int count = ArrayEx.removeDuplicatesFromSortedArray(input);
        Assert.assertEquals(input, expected);
        Assert.assertEquals(count, 0);
    }

    @Test
    public void testRemoveDuplicatesFromSortedArray05() throws Exception {
        Integer[] input = {1, 2, 3, 3};
        Integer[] expected = {1, 2, 3, 3};
        int count = ArrayEx.removeDuplicatesFromSortedArray(input);
        Assert.assertEquals(input, expected);
        Assert.assertEquals(count, 3);
    }
}