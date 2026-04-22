package com.javafortesters.lecture09;

import com.javafortesters.Calculator;
import com.javafortesters.Item;
import com.javafortesters.ShoppingCart;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.within;

class TaggingTest {

    @Test
    @Tag("smoke")
    void calculatorCanAddTwoNumbers() {
        assertThat(new Calculator().add(1, 1)).isEqualTo(2);
    }

    @Test
    @Tag("smoke")
    @Tag("cart")
    void newShoppingCartIsEmpty() {
        assertThat(new ShoppingCart().isEmpty()).isTrue();
    }

    @Test
    @Tag("regression")
    void calculatorHandlesNegativeNumbers() {
        assertThat(new Calculator().add(-10, -5)).isEqualTo(-15);
    }

    @Test
    @Tag("regression")
    @Tag("cart")
    void cartTotalIsCorrectForMultipleItems() {
        ShoppingCart cart = new ShoppingCart();
        cart.addItem(new Item("Book", 12.99));
        cart.addItem(new Item("Pen", 1.49));
        assertThat(cart.getTotal()).isCloseTo(14.48, within(0.01));
    }

    @Test
    @Disabled("Cart discount feature not yet implemented")
    void cartAppliesDiscountForLargeOrders() {
        ShoppingCart cart = new ShoppingCart();
        cart.addItem(new Item("Laptop", 60.00));
        assertThat(cart.getTotal()).isLessThan(60.00);
    }
}
