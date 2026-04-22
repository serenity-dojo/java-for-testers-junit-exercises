package com.javafortesters.lecture09;

import com.javafortesters.Calculator;
import com.javafortesters.Item;
import com.javafortesters.ShoppingCart;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.within;

/**
 * Lecture 9 Exercise — @Disabled and @Tag
 *
 * Tags let you group tests and run only a subset (e.g. "smoke" tests in CI).
 * @Disabled lets you skip a test temporarily with a documented reason.
 *
 * Your tasks:
 *
 *   1. Add @Tag("smoke") to calculatorCanAddTwoNumbers
 *      — a quick sanity check that the calculator works at all
 *
 *   2. Add @Tag("smoke") and @Tag("cart") to newShoppingCartIsEmpty
 *      — a quick check that the cart initialises correctly
 *
 *   3. Add @Tag("regression") to calculatorHandlesNegativeNumbers
 *      — a more detailed check, run as part of the full regression suite
 *
 *   4. Add @Tag("regression") and @Tag("cart") to cartTotalIsCorrectForMultipleItems
 *
 *   5. Add @Disabled("Cart discount feature not yet implemented") to
 *      cartAppliesDiscountForLargeOrders — this test is for a feature that
 *      doesn't exist yet. Disabling it with a reason keeps it visible but
 *      stops it blocking the build.
 *
 * After completing, try running only the "smoke" tagged tests:
 *   In IntelliJ: Edit Run Configuration > Tags > smoke
 */
class TaggingTest {

    // TODO: Add @Tag("smoke") here
    @Test
    void calculatorCanAddTwoNumbers() {
        assertThat(new Calculator().add(1, 1)).isEqualTo(2);
    }

    // TODO: Add @Tag("smoke") and @Tag("cart") here
    @Test
    void newShoppingCartIsEmpty() {
        assertThat(new ShoppingCart().isEmpty()).isTrue();
    }

    // TODO: Add @Tag("regression") here
    @Test
    void calculatorHandlesNegativeNumbers() {
        assertThat(new Calculator().add(-10, -5)).isEqualTo(-15);
    }

    // TODO: Add @Tag("regression") and @Tag("cart") here
    @Test
    void cartTotalIsCorrectForMultipleItems() {
        ShoppingCart cart = new ShoppingCart();
        cart.addItem(new Item("Book", 12.99));
        cart.addItem(new Item("Pen", 1.49));
        assertThat(cart.getTotal()).isCloseTo(14.48, within(0.01));
    }

    // TODO: Add @Disabled("Cart discount feature not yet implemented") here
    //       This test is for a feature that hasn't been built yet.
    //       Without @Disabled it will fail and block the build — disable it with a reason.
    @Test
    void cartAppliesDiscountForLargeOrders() {
        ShoppingCart cart = new ShoppingCart();
        cart.addItem(new Item("Laptop", 60.00));
        // This will fail — the discount feature doesn't exist yet
        assertThat(cart.getTotal()).isLessThan(60.00);
    }
}
