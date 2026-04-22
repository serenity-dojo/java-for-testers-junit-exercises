package com.javafortesters.lecture03;

import com.javafortesters.Item;
import com.javafortesters.ShoppingCart;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.within;

class ShoppingCartLifecycleTest {

    private ShoppingCart cart;

    @BeforeEach
    void setUp() {
        cart = new ShoppingCart();
    }

    @Test
    void newCartIsEmpty() {
        assertThat(cart.isEmpty()).isTrue();
    }

    @Test
    void addingOneItemIncreasesCountToOne() {
        cart.addItem(new Item("Apple", 0.99));
        assertThat(cart.getItemCount()).isEqualTo(1);
    }

    @Test
    void totalReflectsAllAddedItems() {
        cart.addItem(new Item("Apple", 0.99));
        cart.addItem(new Item("Bread", 1.49));
        assertThat(cart.getTotal()).isCloseTo(2.48, within(0.01));
    }

    @Test
    void clearingCartLeavesItEmpty() {
        cart.addItem(new Item("Milk", 0.89));
        cart.clear();
        assertThat(cart.isEmpty()).isTrue();
    }
}
