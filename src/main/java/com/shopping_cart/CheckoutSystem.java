package com.shopping_cart;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by davicres on 11/04/2016.
 */
public class CheckoutSystem {
    public BigDecimal totalCost(List<Item> items) {
        BigDecimal totalCost = new BigDecimal("0.0");
        for (Item item: items) {
            totalCost = totalCost.add(item.getCost());
        }
        return totalCost;
    }
}
