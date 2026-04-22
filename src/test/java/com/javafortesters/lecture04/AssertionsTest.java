package com.javafortesters.lecture04;

import com.javafortesters.Calculator;
import com.javafortesters.Item;
import com.javafortesters.ShoppingCart;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.within;

/**
 * Lecture 4 Exercise — Writing Good Assertions
 *
 * Each test below has a problem with its assertion.
 * The tests compile and run, but they don't prove what they claim to test.
 *
 * Your tasks — fix the assertion in each test:
 *   1. subtractReturnsCorrectResult   — assertion is too weak (isNotNull on an int!)
 *   2. multiplyReturnsCorrectResult   — assertion checks the wrong value
 *   3. cartTotalIsCorrectForTwoItems  — assertion checks the wrong thing entirely
 *   4. newCartHasZeroItems            — assertion is too vague
 *
 * After fixing, apply the mutation question from Lecture 6 (AI section):
 * "If I broke this code, would this test now fail?" — it should.
 */
class AssertionsTest {

    @Test
    void subtractReturnsCorrectResult() {
        Calculator calculator = new Calculator();
        int result = calculator.subtract(10, 3);

        // TODO: This assertion is too weak — isNotNull() on an int never fails.
        //       Fix it: assert that result equals the correct value (7)
        //       Hint: assertThat(result).isEqualTo(...)
        assertThat(result).isNotNull();
    }

    @Test
    void multiplyReturnsCorrectResult() {
        Calculator calculator = new Calculator();
        int result = calculator.multiply(4, 5);

        // TODO: This assertion checks the wrong expected value.
        //       Fix it: 4 * 5 = 20, not 25
        assertThat(result).isEqualTo(25);
    }

    @Test
    void cartTotalIsCorrectForTwoItems() {
        ShoppingCart cart = new ShoppingCart();
        cart.addItem(new Item("Milk", 1.20));
        cart.addItem(new Item("Eggs", 2.50));

        // TODO: This assertion checks the cart object itself rather than its total.
        //       Fix it: assert that cart.getTotal() is close to 3.70
        //       Hint: assertThat(cart.getTotal()).isCloseTo(3.70, within(0.01))
        assertThat(cart).isNotNull();
    }

    @Test
    void newCartHasZeroItems() {
        ShoppingCart cart = new ShoppingCart();

        // TODO: This assertion checks the size of cart.getItems() but tests it incorrectly.
        //       Fix it: assert that cart.getItemCount() equals 0
        //       Hint: assertThat(cart.getItemCount()).isEqualTo(...)
        assertThat(cart.getItems().size()).isGreaterThanOrEqualTo(0);
    }
}
