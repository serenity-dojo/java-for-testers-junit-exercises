package com.javafortesters.lecture08;

import com.javafortesters.Calculator;
import com.javafortesters.Item;
import com.javafortesters.ShoppingCart;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Lecture 8 Exercise — Handling Expected Exceptions
 *
 * Sometimes the correct behaviour IS throwing an exception.
 * JUnit 6 gives us assertThrows() to test for this cleanly.
 *
 * Your tasks:
 *
 *   1. dividingByZeroThrowsArithmeticException
 *      Use assertThrows to verify Calculator.divide(10, 0) throws ArithmeticException
 *
 *   2. dividingByZeroHasInformativeMessage
 *      Capture the exception from assertThrows, then use AssertJ to check
 *      that the message contains "Cannot divide by zero"
 *
 *   3. removingItemNotInCartThrowsException
 *      Use assertThrows to verify that removing an item that was never added
 *      throws an IllegalArgumentException
 *
 * Syntax reminder:
 *   ExceptionType exception = assertThrows(
 *       ExceptionType.class,
 *       () -> codeToRun()
 *   );
 */
class ExceptionHandlingTest {

    @Test
    void dividingByZeroThrowsArithmeticException() {
        Calculator calculator = new Calculator();

        // TODO: Use assertThrows to verify that calculator.divide(10, 0)
        //       throws an ArithmeticException
        //       You don't need to capture the exception for this test —
        //       just assertThrows(ArithmeticException.class, () -> ...)
    }

    @Test
    void dividingByZeroExceptionHasInformativeMessage() {
        Calculator calculator = new Calculator();

        // TODO: Use assertThrows and capture the returned exception into a variable
        //       ArithmeticException exception = assertThrows(...)
        // TODO: Then assert that exception.getMessage() contains "Cannot divide by zero"
        //       Hint: assertThat(exception.getMessage()).contains("Cannot divide by zero")
    }

    @Test
    void removingItemNotInCartThrowsIllegalArgumentException() {
        ShoppingCart cart = new ShoppingCart();
        Item itemNotInCart = new Item("Ghost Item", 9.99);

        // TODO: Use assertThrows to verify that calling cart.removeItem(itemNotInCart)
        //       throws an IllegalArgumentException
        //       (The item was never added, so removing it should throw)
    }
}
