package com.javafortesters.lecture03;

import com.javafortesters.Item;
import com.javafortesters.ShoppingCart;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.within;

/**
 * Lecture 3 Exercise — The Test Lifecycle
 *
 * These four tests all need a ShoppingCart to work with.
 * Without @BeforeEach, you'd have to create one inside every test method.
 *
 * Your tasks:
 *   1. Declare a ShoppingCart field at the top of this class
 *   2. Add a @BeforeEach method that creates a fresh ShoppingCart before each test
 *   3. Complete each test method using the 'cart' field
 */
class ShoppingCartLifecycleTest {

    // TODO: Declare a private ShoppingCart field here named 'cart'
    //       Example: private ShoppingCart cart;


    // TODO: Add a @BeforeEach method named 'setUp'
    //       Inside it, assign: cart = new ShoppingCart();
    //       This runs automatically before each test, giving every test a clean cart


    @Test
    void newCartIsEmpty() {
        // TODO: Assert that cart.isEmpty() returns true
        // Hint: assertThat(cart.isEmpty()).isTrue()
    }

    @Test
    void addingOneItemIncreasesCountToOne() {
        // TODO: Create an Item("Apple", 0.99) and add it to the cart
        // TODO: Assert that cart.getItemCount() equals 1
    }

    @Test
    void totalReflectsAllAddedItems() {
        // TODO: Add two items to the cart:
        //       new Item("Apple", 0.99) and new Item("Bread", 1.49)
        // TODO: Assert that cart.getTotal() is close to 2.48
        //       Hint: assertThat(cart.getTotal()).isCloseTo(2.48, within(0.01))
    }

    @Test
    void clearingCartLeavesItEmpty() {
        // TODO: Add any item to the cart (e.g. new Item("Milk", 0.89))
        // TODO: Call cart.clear()
        // TODO: Assert that cart.isEmpty() returns true
    }
}
