package com.shopping_cart;

import java.math.BigDecimal;

/**
 * Created by davicres on 11/04/2016.
 */
public class Item {
    final private BigDecimal cost;
    final private long codbar;

    public Item(String cost, long codbar) {
        this.cost = new BigDecimal(cost);
        this.codbar = codbar;
    }

    public BigDecimal getCost() {
        return cost;
    }
}
