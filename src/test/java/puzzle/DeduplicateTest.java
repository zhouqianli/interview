package puzzle;

import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class DeduplicateTest {

    @Test
    public void testRemoveDuplicateBrace() throws Exception {
        Assert.assertEquals(Deduplicate.removeDuplicateBrace("a"),"a");
        Assert.assertEquals(Deduplicate.removeDuplicateBrace("(a)"),"(a)");
        Assert.assertEquals(Deduplicate.removeDuplicateBrace("(a+b)"),"(a+b)");
        Assert.assertEquals(Deduplicate.removeDuplicateBrace("(a+b)+c"),"(a+b)+c");
        Assert.assertEquals(Deduplicate.removeDuplicateBrace("((a+b))+c"),"(a+b)+c");
        Assert.assertEquals(Deduplicate.removeDuplicateBrace("((((a+b))+c))"),"((a+b)+c)");
    }
    @Test(expectedExceptions = Exception.class)
    public void testRemoveDuplicateBraceWithException() throws Exception {
        Assert.assertEquals(Deduplicate.removeDuplicateBrace("((((a+b)))+c))"),"((a+b)+c)");
    }
}