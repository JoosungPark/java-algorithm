package com.example.myapplication.primitives;

public class CountBits {
    public static short countBits(int x) {
        short numbBits = 0;
        while (x != 0) {
            numbBits += (x & 1);
            x >>>= 1;
        }
        return numbBits;
    }
}
