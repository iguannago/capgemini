package com.shopping_cart;

import java.util.Iterator;
import java.util.List;

/**
 * Created by davicres on 11/04/2016.
 */
public class BuyOneGetOneFreeApple implements Offer {
    @Override
    public void apply(List<? extends Item> items) {
        int freeApples = getNumOfApples(items) / 2;
        Iterator<? extends Item> iter = items.iterator();
        while(iter.hasNext()&&freeApples!=0) {
            Item item = iter.next();
            if (item.getClass().equals(Apple.class)) {
                iter.remove();
                freeApples--;
            }
        }
    }

    private int getNumOfApples(List<? extends Item> items) {
        int numApples = 0;
        for (Item item: items) {
            if (item.getClass().equals(Apple.class)) {
                numApples++;
            }
        }
        return numApples;
    }
}
