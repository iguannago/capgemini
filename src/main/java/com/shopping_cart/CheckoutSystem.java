package com.shopping_cart;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by davicres on 11/04/2016.
 */
public final class CheckoutSystem {
    private Offer offer;

    public String totalCost(List<? extends Item> items) {
        BigDecimal totalCost = new BigDecimal("0.0");
        if (offer != null) {
            offer.apply(items);
        }
        for (Item item: items) {
            totalCost = totalCost.add(item.getCost());
        }
        return "£" + totalCost;
    }

    public void setOffer(Offer offer) {
        this.offer = offer;
    }

}
