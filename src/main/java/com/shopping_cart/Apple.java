package com.shopping_cart;

/**
 * Created by davicres on 11/04/2016.
 */
public final class Apple extends Item {
    public Apple(String cost, long codbar) {
        super(cost, codbar);
    }

    @Override
    public String toString() {
        return "Apple";
    }
}
