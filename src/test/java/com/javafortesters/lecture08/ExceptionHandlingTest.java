package com.javafortesters.lecture08;

import com.javafortesters.Calculator;
import com.javafortesters.Item;
import com.javafortesters.ShoppingCart;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ExceptionHandlingTest {

    @Test
    void dividingByZeroThrowsArithmeticException() {
        Calculator calculator = new Calculator();

        assertThrows(ArithmeticException.class, () ->
            calculator.divide(10, 0)
        );
    }

    @Test
    void dividingByZeroExceptionHasInformativeMessage() {
        Calculator calculator = new Calculator();

        ArithmeticException exception = assertThrows(ArithmeticException.class, () ->
            calculator.divide(10, 0)
        );

        assertThat(exception.getMessage()).contains("Cannot divide by zero");
    }

    @Test
    void removingItemNotInCartThrowsIllegalArgumentException() {
        ShoppingCart cart = new ShoppingCart();
        Item itemNotInCart = new Item("Ghost Item", 9.99);

        assertThrows(IllegalArgumentException.class, () ->
            cart.removeItem(itemNotInCart)
        );
    }
}
