package com.javafortesters.lecture06;

import com.javafortesters.Item;
import com.javafortesters.ShoppingCart;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.within;

@DisplayName("ShoppingCart")
class ShoppingCartNestedTest {

    private ShoppingCart cart;

    @BeforeEach
    void setUp() {
        cart = new ShoppingCart();
    }

    @Nested
    @DisplayName("When the cart is empty")
    class WhenCartIsEmpty {

        @Test
        void isEmptyReturnsTrue() {
            assertThat(cart.isEmpty()).isTrue();
        }

        @Test
        void totalIsZero() {
            assertThat(cart.getTotal()).isEqualTo(0.0);
        }
    }

    @Nested
    @DisplayName("When the cart has one item")
    class WhenCartHasOneItem {

        @BeforeEach
        void addOneItem() {
            cart.addItem(new Item("Apple", 0.99));
        }

        @Test
        void isEmptyReturnsFalse() {
            assertThat(cart.isEmpty()).isFalse();
        }

        @Test
        void itemCountIsOne() {
            assertThat(cart.getItemCount()).isEqualTo(1);
        }

        @Test
        void totalReflectsItemPrice() {
            assertThat(cart.getTotal()).isCloseTo(0.99, within(0.01));
        }
    }

    @Nested
    @DisplayName("When the cart has multiple items")
    class WhenCartHasMultipleItems {

        @BeforeEach
        void addMultipleItems() {
            cart.addItem(new Item("Apple", 0.99));
            cart.addItem(new Item("Bread", 1.49));
            cart.addItem(new Item("Milk", 0.89));
        }

        @Test
        void itemCountReflectsAllAddedItems() {
            assertThat(cart.getItemCount()).isEqualTo(3);
        }

        @Test
        void totalIsTheSumOfAllItemPrices() {
            // Apple (0.99) + Bread (1.49) + Milk (0.89) = 3.37
            assertThat(cart.getTotal()).isCloseTo(3.37, within(0.01));
        }

        @Test
        void clearingCartRemovesAllItems() {
            cart.clear();
            assertThat(cart.isEmpty()).isTrue();
            assertThat(cart.getItemCount()).isEqualTo(0);
        }
    }
}
