package com.shopping_cart;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;


/**
 * Created by davicres on 11/04/2016.
 */
public class CheckoutSystemTest {
    @Test
    public void totalCostForAnAppleAndAnOrangeTest() {
        CheckoutSystem checkoutSystem = new CheckoutSystem();
        long codbarApple = 123;
        long codbarOrange = 1234;
        List<Item> items = Arrays.asList(new Apple("0.60", codbarApple), new Orange("0.25", codbarOrange));
        BigDecimal totalCost = checkoutSystem.totalCost(items);
        assertEquals(new BigDecimal("0.85"), totalCost);
    }
}
