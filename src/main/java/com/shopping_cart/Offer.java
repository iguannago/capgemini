package com.shopping_cart;

import java.util.List;

/**
 * Created by davicres on 11/04/2016.
 */
public interface Offer {
    void apply(List<? extends Item> items);

    default boolean isEqualsToObj(Item item, Class<? extends Item> obj) {
        return item.getClass().equals(obj);
    }

    default int getNumOfItemsForTheGivenObject(List<? extends Item> items, Class<? extends Item> obj) {
        int numItems = 0;
        for (Item item: items) {
            if (isEqualsToObj(item, obj)) {
                numItems++;
            }
        }
        return numItems;
    }

}
