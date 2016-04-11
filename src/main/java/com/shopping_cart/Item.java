package com.shopping_cart;

import java.math.BigDecimal;

/**
 * Created by davicres on 11/04/2016.
 */
public class Item {
    final BigDecimal cost;
    final long codbar;

    public Item(String cost, long codbar) {
        this.cost = new BigDecimal(cost);
        this.codbar = codbar;
    }
}
