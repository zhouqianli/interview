package cict.ch01;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.security.InvalidParameterException;

import static org.testng.Assert.*;

public class Q1_1Test {

    @Test
    public void testIsUniqueChars() throws Exception {
        Assert.assertTrue(Q1_1.isUniqueChars("abcder*)^%$"));
        Assert.assertTrue(Q1_1.isUniqueChars("a"));
        Assert.assertFalse(Q1_1.isUniqueChars("aaaa"));
        Assert.assertFalse(Q1_1.isUniqueChars("ablkj;lk;lkj;"));
        Assert.assertFalse(Q1_1.isUniqueChars(" abcder*)^%$ "));
        Assert.assertFalse(Q1_1.isUniqueChars("  "));
    }

    @Test(expectedExceptions = InvalidParameterException.class)
    public void testIsUniqueCharsWithNullInput() throws Exception {
        Q1_1.isUniqueChars(null);
    }

    @Test(expectedExceptions = InvalidParameterException.class)
    public void testIsUniqueCharsWithErrorInput() throws Exception {
        Q1_1.isUniqueChars("");
    }

    @Test
    public void testIsUniqueChars_NoAdditionalData() throws Exception {
        Assert.assertTrue(Q1_1.isUniqueChars_NoAdditionalData("abcder*)^%$"));
        Assert.assertTrue(Q1_1.isUniqueChars_NoAdditionalData("a"));
        Assert.assertFalse(Q1_1.isUniqueChars_NoAdditionalData("aaaa"));
        Assert.assertFalse(Q1_1.isUniqueChars_NoAdditionalData("ablkj;lk;lkj;"));
        Assert.assertFalse(Q1_1.isUniqueChars_NoAdditionalData(" abcder*)^%$ "));
        Assert.assertFalse(Q1_1.isUniqueChars_NoAdditionalData("  "));
    }
}