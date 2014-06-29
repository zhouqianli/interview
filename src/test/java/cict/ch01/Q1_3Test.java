package cict.ch01;

import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class Q1_3Test {

    @Test
    public void testIsPermutation() throws Exception {
        String[][] pairs =
                {
                        {null, null},
                        {null, " "},
                        {"", ""},
                        {" ", " "},
                        {"apple", "papel"},
                        {"carrot", "tarroc"},
                        {"hello", "llloh"}
                };
        boolean[] results = {
                false,
                false,
                true,
                true,
                true,
                true,
                false
        };

        for (int i = 0; i < pairs.length; ++i)
            Assert.assertEquals(Q1_3.isPermutation(pairs[i][0], pairs[i][1]), results[i], String.valueOf(i));


    }
}