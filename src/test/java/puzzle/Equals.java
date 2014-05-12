package puzzle;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author zhouzh on 5/12/2014.
 */
@Test
public class Equals {
    public void testLongShortEquals() {
        short v1 = 1800;
        Long v2 = new Long("1800");
        Long v3 = new Long(18);
        Short v4 = new Short(v1);

        Assert.assertTrue(v1 == v2);
    }
}
