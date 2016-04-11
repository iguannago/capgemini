package com.shopping_cart;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;


/**
 * Created by davicres on 11/04/2016.
 */
@RunWith(JUnitParamsRunner.class)
public class CheckoutSystemTest {

    public static final String APPLE_COST = "0.60";
    public static final String ORANGE_COST = "0.25";
    private CheckoutSystem checkoutSystem = new CheckoutSystem();
    private List<Item> items = new ArrayList<Item>();
    public static final long CODBAR_APPLE = 123;
    public static final long CODBAR_ORANGE = 1234;


    @Test
    @Parameters(method = "getAmountOfApplesAndOranges")
    public void totalCostTest(int numApples, int numOranges) {
        items = createGivenNumberOfApplesAndOrangesInTheListItems(numApples, numOranges);
        String totalCost = checkoutSystem.totalCost(items);
        System.out.println("totalCost: " + totalCost);
        assertEquals(workOutExpectedResult(items), totalCost);
    }


    @Test
    @Parameters(method = "getAmountOfApplesAndOranges")
    public void totalCostWhenBuyOneGetOneFreeOnAppleTest(int numApples, int numOranges) {
        checkoutSystem.setOffer(new BuyOneGetOneFreeApple());
        items = createGivenNumberOfApplesAndOrangesInTheListItems(numApples, numOranges);
        System.out.println("items before offer applied: " + items);
        String totalCost = checkoutSystem.totalCost(items);
        System.out.println("items after offer applied: " + items);
        System.out.println("totalCost: " + totalCost);
        BigDecimal expected = new BigDecimal(APPLE_COST).multiply(BigDecimal.valueOf(numApples - (numApples/2))).
                add(new BigDecimal(ORANGE_COST).multiply(BigDecimal.valueOf(numOranges)));
        assertEquals("£"+expected, totalCost);
    }


    @Test
    @Parameters(method = "getAmountOfApplesAndOranges")
    public void totalCostWhenThreeForThePriceOfTwoOrangesTest(int numApples, int numOranges) {
        checkoutSystem.setOffer(new ThreeForThePriceOfTwoOranges());
        items = createGivenNumberOfApplesAndOrangesInTheListItems(numApples, numOranges);
        System.out.println("items before offer applied: " + items);
        String totalCost = checkoutSystem.totalCost(items);
        System.out.println("items after offer applied: " + items);
        System.out.println("totalCost: " + totalCost);
        BigDecimal expected = new BigDecimal(ORANGE_COST).multiply(BigDecimal.valueOf(numOranges - (numOranges/3))).
                add(new BigDecimal(APPLE_COST).multiply(BigDecimal.valueOf(numApples)));
        assertEquals("£"+expected, totalCost);
    }

    private static final Object[] getAmountOfApplesAndOranges() {
        return new Integer[][]{
                {1,1}, {2,2}, {3,1}, {4,5}, {0,0}, {10, 20}, {3,4}, {10,0}, {0,10}, {7,9}, {2,1}, {6,3},
                {2,3}, {1,6}
        };
    }

    private String workOutExpectedResult(List<Item> items) {
        BigDecimal totalcost = new BigDecimal("0.00");
        for (Item item: items) {
            totalcost = totalcost.add(item.getCost());
        }
        return "£" + totalcost;
    }

    private List<Item> createGivenNumberOfApplesAndOrangesInTheListItems(int numApples, int numOranges) {
        Item item;
        for (int i = 0; i < numApples; i++) {
            item = new Apple(APPLE_COST, CODBAR_APPLE);
            items.add(item);
        }
        for (int i = 0; i < numOranges; i++) {
            item = new Orange(ORANGE_COST, CODBAR_ORANGE);
            items.add(item);
        }
        return items;
    }



}
