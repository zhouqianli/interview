package cict.ch01;

import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

@Test
public class Q1_2Test {
    public void testResverse() {
        String input = "abcdefg";
        Assert.assertTrue(Q1_2.INSTANCE.reverse(Q1_2.INSTANCE.reverse(input)).equals(input));
        Assert.assertNull(Q1_2.INSTANCE.reverse(Q1_2.INSTANCE.reverse(null)));
        input = "";
        Assert.assertTrue(Q1_2.INSTANCE.reverse(Q1_2.INSTANCE.reverse(input)).equals(input));
        input = " ";
        Assert.assertTrue(Q1_2.INSTANCE.reverse(Q1_2.INSTANCE.reverse(input)).equals(input));
    }

}