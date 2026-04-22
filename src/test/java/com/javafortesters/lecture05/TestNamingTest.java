package com.javafortesters.lecture05;

import com.javafortesters.Calculator;
import com.javafortesters.Item;
import com.javafortesters.ShoppingCart;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TestNamingTest {

    // ── Part A: Renamed tests ─────────────────────────────────────────────────

    @Test
    void multiplyingAnyNumberByZeroReturnsZero() {
        Calculator calc = new Calculator();
        assertThat(calc.multiply(99, 0)).isEqualTo(0);
    }

    @Test
    void subtractingANumberFromItselfReturnsZero() {
        Calculator calc = new Calculator();
        assertThat(calc.subtract(7, 7)).isEqualTo(0);
    }

    @Test
    void newShoppingCartIsEmpty() {
        ShoppingCart cart = new ShoppingCart();
        assertThat(cart.isEmpty()).isTrue();
    }

    @Test
    void addingOneItemSetsCountToOne() {
        ShoppingCart cart = new ShoppingCart();
        cart.addItem(new Item("Apple", 0.99));
        assertThat(cart.getItemCount()).isEqualTo(1);
    }

    // ── Part B: @DisplayName added ───────────────────────────────────────────

    @Test
    @DisplayName("Adding two negative numbers returns their sum")
    void addsTwoNegativeNumbers() {
        Calculator calc = new Calculator();
        assertThat(calc.add(-3, -4)).isEqualTo(-7);
    }

    @Test
    @DisplayName("Removing the only item leaves the cart empty")
    void removingOnlyItemLeavesCartEmpty() {
        ShoppingCart cart = new ShoppingCart();
        Item apple = new Item("Apple", 0.99);
        cart.addItem(apple);
        cart.removeItem(apple);
        assertThat(cart.isEmpty()).isTrue();
    }

    @Test
    @DisplayName("An empty cart has a total of zero")
    void cartTotalIsZeroWhenEmpty() {
        ShoppingCart cart = new ShoppingCart();
        assertThat(cart.getTotal()).isEqualTo(0.0);
    }
}
