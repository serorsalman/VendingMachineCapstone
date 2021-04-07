package com.techelevator.inventory;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class ChipsTest extends TestCase {
    public static final String TEXT_RESET = "\u001B[0m";
    public static final String TEXT_GREEN = "\u001B[32m";
    public void testMessageReturns_Crunch_Crunch_Yum() {
        Chips chips = new Chips("A1","Ruffles",new BigDecimal("2.00"));
        String expected = TEXT_GREEN + "\r\nCrunch Crunch, Yum!" + TEXT_RESET;
        String actual = chips.messageReturned();
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void test_for_name() {
        Chips chips = new Chips("A1","Ruffles",new BigDecimal("2.00"));
        String expected = "Ruffles";
        String actual = chips.getName();
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void test_for_slot(){
        Chips chips = new Chips("A1","Ruffles",new BigDecimal("2.00"));
        String expected = "A1";
        String actual = chips.getSlot();
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void test_for_getPrice(){
        Chips chips = new Chips("A1","Ruffles",new BigDecimal("2.00"));
        String expected = "2.00";
        String actual = String.valueOf(chips.getPrice());
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void test_for_getQuantity(){
        Chips chips = new Chips("A1","Ruffles",new BigDecimal("2.00"));
        int expected = 5;
        int actual = chips.getQuantity();
        Assert.assertEquals(expected, actual);
    }
}