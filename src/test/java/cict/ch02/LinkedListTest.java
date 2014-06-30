package cict.ch02;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class LinkedListTest {

    private LinkedList<Integer> a = new LinkedList<>();

    @BeforeMethod
    public void setUp() throws Exception {
        a.append(55);
        a.append(66);
        a.append(77);
        a.append(11);
        a.append(22);
        a.append(33);
    }


    @Test
    public void testPartition() throws Exception {
        a.partition(50);
        boolean isBigger = false;
        for (Integer item : a.toArray()) {
            if (!isBigger && item >= 50)
                isBigger = true;
            if (isBigger && item < 50)
                Assert.fail();
        }
    }
}