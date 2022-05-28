package com.example.myapplication.primitives.parity;

import org.junit.Assert;
import org.junit.Test;

public class Parity {

    public static short bruteForceParity(long x) {
        short result = 0;
        while (x != 0) {
            result ^= (x & 1);
            x >>>= 1;
        }
        return result;
    }

    @Test
    public void testBruteForceParity() {
        long target = 0x0101001;
        System.out.printf("target %d%n", target);
        short result = bruteForceParity(target);
        int odd = result % 2;
        System.out.printf("result is %s%n", odd == 0 ? "odd" : "not odd");
        Assert.assertEquals(odd, odd == 0 ? 0 : 1);
    }
}
