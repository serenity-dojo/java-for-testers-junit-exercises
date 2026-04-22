package com.javafortesters.lecture02;

import com.javafortesters.Calculator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CalculatorBasicTest {

    @Test
    void addsTwoPositiveNumbers() {
        Calculator calculator = new Calculator();
        int result = calculator.add(3, 4);
        assertThat(result).isEqualTo(7);
    }

    @Test
    void addsTwoNegativeNumbers() {
        Calculator calculator = new Calculator();
        int result = calculator.add(-2, -3);
        assertThat(result).isEqualTo(-5);
    }

    @Test
    void addsPositiveAndNegativeNumber() {
        Calculator calculator = new Calculator();
        int result = calculator.add(10, -4);
        assertThat(result).isEqualTo(6);
    }
}
