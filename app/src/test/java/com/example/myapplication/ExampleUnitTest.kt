package com.example.myapplication

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    fun solution(N: Int): Int {
        val binaryString = Integer.toBinaryString(N)
        println(" $binaryString")
        var maximumLength = -1
        var length = 0
        var isStarted = false
        for (char in binaryString) {
            if (char == '0') {
                length += 1
            } else if (char == '1') {
                if (isStarted) {
                    isStarted = false
                    if (length > maximumLength) {
                        maximumLength = length
                    }
                    length = 0
                } else {
                    isStarted = true
                }
            }
        }

        if (maximumLength < 0) {
            maximumLength = length
        }

        return maximumLength
    }

    @Test
    fun addition_isCorrect() {
        assertEquals(solution(32), 5)

//        print()
    }
}