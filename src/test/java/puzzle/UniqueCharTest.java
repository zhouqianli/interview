package puzzle;

import com.interview.test.Sub;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author zhouzh
 */
@Test
public class UniqueCharTest {
    @Test
    public void testIsUnique() throws Exception {
        Assert.assertEquals(UniqueChar.isUnique("abc a"),false);
        Assert.assertEquals(UniqueChar.isUnique("abc d"),true);
        Assert.assertEquals(UniqueChar.isUnique("a"),true);
        Assert.assertEquals(UniqueChar.isUnique(" "),true);
        Assert.assertEquals(UniqueChar.isUnique(""),true);
        Assert.assertEquals(UniqueChar.isUnique(null),true);
    }

    @Test
    public void testNoAdditionalStructure() throws Exception {
        Assert.assertEquals(UniqueChar.noAdditionalStructure("abc a"),false);
        Assert.assertEquals(UniqueChar.noAdditionalStructure("abc d"),true);
        Assert.assertEquals(UniqueChar.noAdditionalStructure("a"),true);
        Assert.assertEquals(UniqueChar.noAdditionalStructure(" "),true);
        Assert.assertEquals(UniqueChar.noAdditionalStructure(""),true);
        Assert.assertEquals(UniqueChar.noAdditionalStructure(null),true);
    }

    public void testMainSub() throws Exception{
        new Sub("haha");
    }
}
