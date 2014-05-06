package leetcode;

import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class StringExTest {

    @Test
    public void testStrstr() throws Exception {
        Assert.assertEquals(StringEx.strstr("dkdkd".toCharArray(),"k".toCharArray()),1);
        Assert.assertEquals(StringEx.strstr("This is a test string".toCharArray(),"string".toCharArray()),15);
        Assert.assertEquals(StringEx.strstr("This is a test string".toCharArray(),"that".toCharArray()),-1);
        Assert.assertEquals(StringEx.strstr("".toCharArray(),"that".toCharArray()),-1);
        Assert.assertEquals(StringEx.strstr("".toCharArray(),"".toCharArray()),-1);
    }
}