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
     * 이때 시간 복잡도는 2진수 숫자 x의 길이를 n이라 할 때 O(n)이다.
     */
    @Test
    public void testBruteForceParity() {
        long target = 0x0101001;
        System.out.printf("target %2x%n", target);
        short result = parity(target);
        int odd = result % 2;
        System.out.printf("result is %s%n", odd == 0 ? "odd" : "not odd");
        Assert.assertEquals(odd, odd == 0 ? 0 : 1);
    }

    /**
     * 다음으로 살펴볼 알고리즘은,
     * 1이 나오는 최소자리 비트를 제거하는 방식으로 패리티 비트를 판별하는 방식이다.
     * 즉, while문 내 하나의 operation에서
     * 1. parity bit를 not하고
     * 2. x &= (x - 1)
     * 를 적용해 parity bit를 검출하는 방식이다.
     *
     * target이 101001이라 할 때
     * while문을 돌면서,
     * result 1, after operate : 101000
     * result 0, after operate : 100000
     * result 1, after operate : 00
     * result is not odd
     * 와 같은 결과가 나온다.
     *
     * 이를 적용하면, 2진수 숫자에서 1이 설정된 숫자가 k라 할 때 O(k) 시간 복잡도를 얻는다.
     *
     */
    public static short dropTheLowestSetBit(long x) {
        short result = 0;
        while (x != 0) {
            result ^= 1;
            System.out.printf("result %d%n", result);
            x &= (x - 1);
            System.out.printf("after operate : %02x%n", x);
        }
        return result;
    }

    static int[] precomputedParity = new int[65536]; // 2 ^ 16

    public static short parity(long x) {
        final int MASK_SIZE = 16;
        final int BIT_MASK = 0xFFFF;
        return (short) (precomputedParity[(int) ((x >>> (3 * MASK_SIZE)) & BIT_MASK)] ^
                        precomputedParity[(int) ((x >>> (2 * MASK_SIZE)) & BIT_MASK)] ^
                        precomputedParity[(int) ((x >>> (MASK_SIZE)) & BIT_MASK)] ^
                        precomputedParity[(int) (x & BIT_MASK)]);
    }
}
