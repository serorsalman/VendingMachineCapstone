package com.techelevator.inventory;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class CandyTest extends TestCase {
    public static final String TEXT_RESET = "\u001B[0m";
    public static final String TEXT_GREEN = "\u001B[32m";
    @Test
    public void testMessageReturns_Munch_Munch_Yum() {
        Candy candy = new Candy("B2","Runts",new BigDecimal("1.95"));
        String expected = TEXT_GREEN + "\r\nMunch Munch, Yum!" +TEXT_RESET;
        String actual = candy.messageReturned();
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void test_for_name() {
        Candy candy = new Candy("B2","Runts",new BigDecimal("1.95"));
        String expected = "Runts";
        String actual = candy.getName();
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void test_for_slot(){
        Candy candy = new Candy("B2","Runts",new BigDecimal("1.95"));
        String expected = "B2";
        String actual = candy.getSlot();
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void test_for_getPrice(){
        Candy candy = new Candy("B2","Runts",new BigDecimal("1.95"));
        String expected = "1.95";
        String actual = String.valueOf(candy.getPrice());
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void test_for_getQuantity(){
        Candy candy = new Candy("B2","Runts",new BigDecimal("1.95"));
        int expected = 5;
        int actual = candy.getQuantity();
        Assert.assertEquals(expected, actual);
    }
}