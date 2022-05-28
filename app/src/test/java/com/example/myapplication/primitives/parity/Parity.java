package com.example.myapplication.primitives.parity;

import org.junit.Assert;
import org.junit.Test;

/**
 * 4.1. 2진수의 parity check
 * - 2진수의 parity check는 1의 총 갯수가 홀수일 경우 1, 짝수일 경우 0이며
 * - 이는 데이터 저장 및 통신에 있어 single bit errors를 체크할 때 사용한다.
 *
 * Q. 64-bit words들의 매우 큰 수에 대한 parity를 어떻게 계산할 것인가?
 * How would you compute the parity of a very large number of 64-bit words?
 */
public class Parity {

    public static short bruteForceParity(long x) {
        short result = 0;
        while (x != 0) {
            result ^= (x & 1);
            x >>>= 1;
        }
        return result;
    }

    /**
     * 억지 기법을 사용하면 각 숫자에서 나온 1의 갯수를 전부 세어서 그 결과 값에 mod한 값이 1인지 0인지 판별할 수 있다.
     */
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
