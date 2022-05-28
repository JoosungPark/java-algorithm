package com.example.myapplication.primitives;

import org.junit.Assert;
import org.junit.Test;

public class CountBitsTest {

    @Test
    public void testCountBits() {
        short test01 = 0x100;
        System.out.println(" test01 " + test01);
        Assert.assertEquals(CountBits.countBits(test01), 1);

        short test02 = 0x1011;
        System.out.println(" test02 " + test02);
        Assert.assertEquals(CountBits.countBits(test02), 3);
    }
}
