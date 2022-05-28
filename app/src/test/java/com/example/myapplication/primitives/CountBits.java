package com.example.myapplication.primitives;

import org.junit.Assert;
import org.junit.Test;

public class CountBits {
    public static short countBits(int x) {
        short numbBits = 0;
        while (x != 0) {
            numbBits += (x & 1);
            x >>>= 1;
        }
        return numbBits;
    }

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
