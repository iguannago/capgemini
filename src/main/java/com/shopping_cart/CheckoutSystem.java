package com.shopping_cart;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by davicres on 11/04/2016.
 */
public final class CheckoutSystem {
    private List<? extends Offer> offers = new ArrayList<>();

    public String totalCost(List<? extends Item> items) {
        BigDecimal totalCost = new BigDecimal("0.00");
        for (Offer offer: offers) {
            offer.apply(items);
        }
        for (Item item: items) {
            totalCost = totalCost.add(item.getCost());
        }
        return "£" + totalCost;
    }

    public void setOffers(List<Offer> offers) {
        this.offers = offers;
    }

}
