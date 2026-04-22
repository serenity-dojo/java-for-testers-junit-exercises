package com.javafortesters.lecture07;

import com.javafortesters.Calculator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Lecture 7 Exercise — Parameterised Tests
 *
 * Repetitive tests are a smell — if you're copying and pasting a test and
 * only changing the values, a parameterised test is the answer.
 *
 * ── Part A: @ValueSource ─────────────────────────────────────────────────────
 * The four tests below all do the same thing with different numbers.
 * Replace them with ONE @ParameterizedTest using @ValueSource.
 *
 *   Steps:
 *   1. Delete the four @Test methods (or comment them out)
 *   2. Write a single method: void addingZeroToAnyNumberReturnsThatNumber(int number)
 *   3. Annotate it with @ParameterizedTest and @ValueSource(ints = {1, 5, 10, 100})
 *   4. Inside, call calculator.add(number, 0) and assert the result equals 'number'
 *
 * ── Part B: @CsvSource ───────────────────────────────────────────────────────
 * The four tests below test add() with different inputs AND different expected values.
 * Replace them with ONE @ParameterizedTest using @CsvSource.
 *
 *   Steps:
 *   1. Delete the four @Test methods (or comment them out)
 *   2. Write a single method: void addReturnsCorrectSum(int a, int b, int expected)
 *   3. Annotate it with @ParameterizedTest and @CsvSource listing the four rows
 *   4. Inside, assert that calculator.add(a, b) equals expected
 */
class CalculatorParameterisedTest {

    // ── Part A: Replace these four tests with one @ParameterizedTest + @ValueSource

    @Test
    void addingZeroToOneShouldReturnOne() {
        assertThat(new Calculator().add(1, 0)).isEqualTo(1);
    }

    @Test
    void addingZeroToFiveShouldReturnFive() {
        assertThat(new Calculator().add(5, 0)).isEqualTo(5);
    }

    @Test
    void addingZeroToTenShouldReturnTen() {
        assertThat(new Calculator().add(10, 0)).isEqualTo(10);
    }

    @Test
    void addingZeroToOneHundredShouldReturnOneHundred() {
        assertThat(new Calculator().add(100, 0)).isEqualTo(100);
    }


    // ── Part B: Replace these four tests with one @ParameterizedTest + @CsvSource

    @Test
    void addingThreeAndFourShouldReturnSeven() {
        assertThat(new Calculator().add(3, 4)).isEqualTo(7);
    }

    @Test
    void addingNegativeFiveAndThreeShouldReturnNegativeTwo() {
        assertThat(new Calculator().add(-5, 3)).isEqualTo(-2);
    }

    @Test
    void addingZeroAndZeroShouldReturnZero() {
        assertThat(new Calculator().add(0, 0)).isEqualTo(0);
    }

    @Test
    void addingTenAndNegativeTenShouldReturnZero() {
        assertThat(new Calculator().add(10, -10)).isEqualTo(0);
    }
}
