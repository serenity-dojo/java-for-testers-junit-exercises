package com.javafortesters.lecture04;

import com.javafortesters.Calculator;
import com.javafortesters.Item;
import com.javafortesters.ShoppingCart;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.within;

class AssertionsTest {

    @Test
    void subtractReturnsCorrectResult() {
        Calculator calculator = new Calculator();
        int result = calculator.subtract(10, 3);
        assertThat(result).isEqualTo(7);
    }

    @Test
    void multiplyReturnsCorrectResult() {
        Calculator calculator = new Calculator();
        int result = calculator.multiply(4, 5);
        assertThat(result).isEqualTo(20);
    }

    @Test
    void cartTotalIsCorrectForTwoItems() {
        ShoppingCart cart = new ShoppingCart();
        cart.addItem(new Item("Milk", 1.20));
        cart.addItem(new Item("Eggs", 2.50));
        assertThat(cart.getTotal()).isCloseTo(3.70, within(0.01));
    }

    @Test
    void newCartHasZeroItems() {
        ShoppingCart cart = new ShoppingCart();
        assertThat(cart.getItemCount()).isEqualTo(0);
    }
}
