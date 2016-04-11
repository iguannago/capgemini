package com.shopping_cart;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;


/**
 * Created by davicres on 11/04/2016.
 */
public class CheckoutSystemTest {

    private CheckoutSystem checkoutSystem = new CheckoutSystem();
    private List<Item> items = new ArrayList<Item>();
    public static final long CODBAR_APPLE = 123;
    public static final long CODBAR_ORANGE = 1234;


    @Test
    public void totalCostTest() {
        items = createGivenNumberOfApplesAndOrangesInTheListItems(2,2);
        BigDecimal totalCost = checkoutSystem.totalCost(items);
        assertEquals(workOutExpectedResult(items), totalCost);
    }

    private BigDecimal workOutExpectedResult(List<Item> items) {
        BigDecimal totalcost = new BigDecimal("0.0");
        for (Item item: items) {
            totalcost = totalcost.add(item.getCost());
        }
        return totalcost;
    }

    private List<Item> createGivenNumberOfApplesAndOrangesInTheListItems(int numApples, int numOranges) {
        Item item;
        for (int i = 0; i < numApples; i++) {
            item = new Apple("0.60", CODBAR_APPLE);
            items.add(item);
        }
        for (int i = 0; i < numOranges; i++) {
            item = new Orange("0.25", CODBAR_ORANGE);
            items.add(item);
        }
        return items;
    }


}
