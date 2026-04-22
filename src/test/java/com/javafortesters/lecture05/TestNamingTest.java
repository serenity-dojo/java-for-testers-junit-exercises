package com.javafortesters.lecture05;

import com.javafortesters.Calculator;
import com.javafortesters.Item;
import com.javafortesters.ShoppingCart;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Lecture 5 Exercise — Naming Your Tests
 *
 * The tests below are all correct — they pass with the right assertions.
 * The problem is the names: they describe the method, not the behaviour.
 *
 * Part A — Rename the first four tests (right-click > Refactor > Rename in IntelliJ):
 *   Each name should describe what the code does, not which method is called.
 *   Example: 'test1' → 'addingTwoPositiveNumbersReturnsTheirSum'
 *
 * Part B — Add @DisplayName to the last three tests.
 *   @DisplayName appears in the IntelliJ test runner and makes reports more readable.
 *   Write it as a plain English sentence, e.g. "Adds two positive numbers"
 */
class TestNamingTest {

    // ── Part A: Rename these four tests ──────────────────────────────────────

    @Test
    void test1() {
        // TODO: Rename this method — it tests that multiplying any number by zero gives zero
        Calculator calc = new Calculator();
        assertThat(calc.multiply(99, 0)).isEqualTo(0);
    }

    @Test
    void calculatorTest() {
        // TODO: Rename this method — it tests that subtracting a number from itself gives zero
        Calculator calc = new Calculator();
        assertThat(calc.subtract(7, 7)).isEqualTo(0);
    }

    @Test
    void myTest() {
        // TODO: Rename this method — it tests that a new cart is empty
        ShoppingCart cart = new ShoppingCart();
        assertThat(cart.isEmpty()).isTrue();
    }

    @Test
    void doSomething() {
        // TODO: Rename this method — it tests that adding one item sets the count to 1
        ShoppingCart cart = new ShoppingCart();
        cart.addItem(new Item("Apple", 0.99));
        assertThat(cart.getItemCount()).isEqualTo(1);
    }


    // ── Part B: Add @DisplayName to these three tests ────────────────────────

    // TODO: Add @DisplayName("Adding two negative numbers returns their sum") here
    @Test
    void addsTwoNegativeNumbers() {
        Calculator calc = new Calculator();
        assertThat(calc.add(-3, -4)).isEqualTo(-7);
    }

    // TODO: Add a @DisplayName annotation describing what this test verifies
    @Test
    void removingOnlyItemLeavesCartEmpty() {
        ShoppingCart cart = new ShoppingCart();
        Item apple = new Item("Apple", 0.99);
        cart.addItem(apple);
        cart.removeItem(apple);
        assertThat(cart.isEmpty()).isTrue();
    }

    // TODO: Add a @DisplayName annotation describing what this test verifies
    @Test
    void cartTotalIsZeroWhenEmpty() {
        ShoppingCart cart = new ShoppingCart();
        assertThat(cart.getTotal()).isEqualTo(0.0);
    }
}
