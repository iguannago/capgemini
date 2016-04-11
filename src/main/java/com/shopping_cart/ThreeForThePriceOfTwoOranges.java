package com.shopping_cart;

import java.util.Iterator;
import java.util.List;

/**
 * Created by davicres on 11/04/2016.
 */
public class ThreeForThePriceOfTwoOranges implements Offer {
    @Override
    public void apply(List<? extends Item> items) {
        int freeOranges = getNumOfItemsForTheGivenObject(items, Orange.class) / 3;
        Iterator<? extends Item> iter = items.iterator();
        while(iter.hasNext()&&freeOranges!=0) {
            Item item = iter.next();
            if (isEqualsToObj(item, Orange.class)) {
                iter.remove();
                freeOranges--;
            }
        }
    }
}
