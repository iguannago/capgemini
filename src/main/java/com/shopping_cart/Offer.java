package com.shopping_cart;

import java.util.List;

/**
 * Created by davicres on 11/04/2016.
 */
public interface Offer {
    void apply(List<? extends Item> items);
}
