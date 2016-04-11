package com.shopping_cart;

import java.util.Iterator;
import java.util.List;

/**
 * Created by davicres on 11/04/2016.
 */
public class ThreeForThePriceOfTwoOranges implements Offer {
    @Override
    public void apply(List<? extends Item> items) {
        int freeOranges = getNumOfOranges(items) / 3;
        Iterator<? extends Item> iter = items.iterator();
        while(iter.hasNext()&&freeOranges!=0) {
            Item item = iter.next();
            if (item.getClass().equals(Orange.class)) {
                iter.remove();
                freeOranges--;
            }
        }
    }

    private int getNumOfOranges(List<? extends Item> items) {
        int numOranges = 0;
        for (Item item: items) {
            if (item.getClass().equals(Orange.class)) {
                numOranges++;
            }
        }
        return numOranges;
    }
}
