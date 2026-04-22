package com.javafortesters.lecture06;

import com.javafortesters.Item;
import com.javafortesters.ShoppingCart;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.within;

/**
 * Lecture 6 Exercise — Organising Tests with @Nested
 *
 * The eight tests below are all correct and pass — but they're a flat list.
 * As a test class grows, flat tests become hard to read and navigate.
 *
 * Your task: reorganise these tests into three @Nested inner classes:
 *
 *   @Nested class WhenCartIsEmpty      — tests 1 and 2
 *   @Nested class WhenCartHasOneItem   — tests 3, 4, and 5
 *   @Nested class WhenCartHasMultipleItems — tests 6, 7, and 8
 *
 * Steps:
 *   1. Create each inner class with the @Nested annotation
 *   2. Add @DisplayName to each inner class (e.g. "When the cart is empty")
 *   3. Move the relevant test methods inside each inner class
 *   4. Move the @BeforeEach into each nested class that needs its own setup,
 *      OR keep one at the outer class level — both work, try to understand why
 *
 * After reorganising, run the tests — they should all still pass.
 * Check how they look in the IntelliJ test runner tree.
 */
@DisplayName("ShoppingCart")
class ShoppingCartNestedTest {

    private ShoppingCart cart;

    @BeforeEach
    void setUp() {
        cart = new ShoppingCart();
    }

    // ── Tests 1-2: When the cart is empty ────────────────────────────────────

    @Test
    void isEmptyReturnsTrue() {
        assertThat(cart.isEmpty()).isTrue();
    }

    @Test
    void totalIsZero() {
        assertThat(cart.getTotal()).isEqualTo(0.0);
    }

    // ── Tests 3-5: When the cart has one item ────────────────────────────────

    @Test
    void isEmptyReturnsFalse() {
        cart.addItem(new Item("Apple", 0.99));
        assertThat(cart.isEmpty()).isFalse();
    }

    @Test
    void itemCountIsOne() {
        cart.addItem(new Item("Apple", 0.99));
        assertThat(cart.getItemCount()).isEqualTo(1);
    }

    @Test
    void totalReflectsItemPrice() {
        cart.addItem(new Item("Apple", 0.99));
        assertThat(cart.getTotal()).isCloseTo(0.99, within(0.01));
    }

    // ── Tests 6-8: When the cart has multiple items ──────────────────────────

    @Test
    void itemCountReflectsAllAddedItems() {
        cart.addItem(new Item("Apple", 0.99));
        cart.addItem(new Item("Bread", 1.49));
        cart.addItem(new Item("Milk", 0.89));
        assertThat(cart.getItemCount()).isEqualTo(3);
    }

    @Test
    void totalIsTheSumOfAllItemPrices() {
        cart.addItem(new Item("Apple", 0.99));
        cart.addItem(new Item("Bread", 1.49));
        assertThat(cart.getTotal()).isCloseTo(2.48, within(0.01));
    }

    @Test
    void clearingCartRemovesAllItems() {
        cart.addItem(new Item("Apple", 0.99));
        cart.addItem(new Item("Bread", 1.49));
        cart.clear();
        assertThat(cart.isEmpty()).isTrue();
        assertThat(cart.getItemCount()).isEqualTo(0);
    }
}
