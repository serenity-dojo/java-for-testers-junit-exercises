package com.javafortesters;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * A shopping cart that holds Items.
 * Used throughout the JUnit 6 module exercises.
 */
public class ShoppingCart {

    private final List<Item> items = new ArrayList<>();

    /**
     * Adds an item to the cart.
     */
    public void addItem(Item item) {
        items.add(item);
    }

    /**
     * Removes an item from the cart.
     *
     * @throws IllegalArgumentException if the item is not in the cart
     */
    public void removeItem(Item item) {
        if (!items.contains(item)) {
            throw new IllegalArgumentException(
                "Item not found in cart: " + item.getName()
            );
        }
        items.remove(item);
    }

    /**
     * Returns the total price of all items in the cart.
     */
    public double getTotal() {
        return items.stream()
                    .mapToDouble(Item::getPrice)
                    .sum();
    }

    /**
     * Returns the number of items currently in the cart.
     */
    public int getItemCount() {
        return items.size();
    }

    /**
     * Removes all items from the cart.
     */
    public void clear() {
        items.clear();
    }

    /**
     * Returns true if the cart contains no items.
     */
    public boolean isEmpty() {
        return items.isEmpty();
    }

    /**
     * Returns an unmodifiable view of the items in the cart.
     */
    public List<Item> getItems() {
        return Collections.unmodifiableList(items);
    }
}
