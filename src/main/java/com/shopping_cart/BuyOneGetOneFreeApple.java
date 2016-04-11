package com.shopping_cart;

import java.util.Iterator;
import java.util.List;

/**
 * Created by davicres on 11/04/2016.
 */
public class BuyOneGetOneFreeApple implements Offer {
    @Override
    public void apply(List<? extends Item> items) {
        int freeApples = getNumOfItemsForTheGivenObject(items, Apple.class) / 2;
        Iterator<? extends Item> iter = items.iterator();
        while(iter.hasNext()&&freeApples!=0) {
            Item item = iter.next();
            if (isEqualsToObj(item, Apple.class)) {
                iter.remove();
                freeApples--;
            }
        }
    }

}
