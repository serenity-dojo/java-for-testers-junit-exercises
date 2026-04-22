package com.javafortesters.lecture02;

import com.javafortesters.Calculator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Lecture 2 Exercise — Your First JUnit 6 Tests
 *
 * Write three tests for the Calculator.add() method.
 * Each test should follow the Arrange / Act / Assert pattern.
 *
 * Run the tests in IntelliJ using the green arrow next to the class name.
 * All three should go green once you complete them.
 */
class CalculatorBasicTest {

    @Test
    void addsTwoPositiveNumbers() {
        // TODO: Create a Calculator instance
        // TODO: Call add(3, 4) and store the result
        // TODO: Use assertThat(result).isEqualTo(7) to verify the answer
    }

    @Test
    void addsTwoNegativeNumbers() {
        // TODO: Create a Calculator instance
        // TODO: Call add(-2, -3) and store the result
        // TODO: Use assertThat(result).isEqualTo(-5) to verify the answer
    }

    @Test
    void addsPositiveAndNegativeNumber() {
        // TODO: Create a Calculator instance
        // TODO: Call add(10, -4) and store the result
        // TODO: Use assertThat(result).isEqualTo(6) to verify the answer
    }
}
