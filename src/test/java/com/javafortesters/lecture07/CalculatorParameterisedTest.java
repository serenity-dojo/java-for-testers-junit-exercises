package com.javafortesters.lecture07;

import com.javafortesters.Calculator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class CalculatorParameterisedTest {

    // ── Part A: @ValueSource ──────────────────────────────────────────────────

    @ParameterizedTest
    @ValueSource(ints = {1, 5, 10, 100})
    void addingZeroToAnyNumberReturnsThatNumber(int number) {
        assertThat(new Calculator().add(number, 0)).isEqualTo(number);
    }

    // ── Part B: @CsvSource ────────────────────────────────────────────────────

    @ParameterizedTest
    @CsvSource({
        "3,   4,   7",
        "-5,  3,  -2",
        "0,   0,   0",
        "10, -10,  0"
    })
    void addReturnsCorrectSum(int a, int b, int expected) {
        assertThat(new Calculator().add(a, b)).isEqualTo(expected);
    }
}
