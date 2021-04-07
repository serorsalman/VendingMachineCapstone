package com.techelevator.inventory;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class DrinksTest extends TestCase {
    public static final String TEXT_RESET = "\u001B[0m";
    public static final String TEXT_GREEN = "\u001B[32m";

    @Test
    public void testMessageReturns_Glug_Glug_Yum() {
        Drinks drinks = new Drinks("C3","Pepsi",new BigDecimal("0.99"));
        String expected = TEXT_GREEN + "\r\nGlug Glug, Yum!" + TEXT_RESET;
        String actual = drinks.messageReturned();
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void test_for_name() {
        Drinks drinks = new Drinks("C3","Pepsi",new BigDecimal("0.99"));
        String expected = "Pepsi";
        String actual = drinks.getName();
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void test_for_slot(){
        Drinks drinks = new Drinks("C3","Pepsi",new BigDecimal("0.99"));
        String expected = "C3";
        String actual = drinks.getSlot();
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void test_for_getPrice(){
        Drinks drinks = new Drinks("C3","Pepsi",new BigDecimal("0.99"));
        String expected = "0.99";
        String actual = String.valueOf(drinks.getPrice());
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void test_for_getQuantity(){
        Drinks drinks = new Drinks("C3","Pepsi",new BigDecimal("0.99"));
        int expected = 5;
        int actual = drinks.getQuantity();
        Assert.assertEquals(expected, actual);
    }
}