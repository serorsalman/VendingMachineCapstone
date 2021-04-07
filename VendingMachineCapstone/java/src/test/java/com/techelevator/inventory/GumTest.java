package com.techelevator.inventory;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class GumTest extends TestCase {
    public static final String TEXT_RESET = "\u001B[0m";
    public static final String TEXT_GREEN = "\u001B[32m";

    public void testMessageReturns_Chew_Chew_Yum() {
        Gum gum = new Gum("D4", "Hubba BUBBA", new BigDecimal("0.50"));
        String expected = TEXT_GREEN + "\r\nChew Chew, Yum!" + TEXT_RESET;
        String actual = gum.messageReturned();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void test_for_name() {
        Gum gum = new Gum("D4", "Hubba BUBBA", new BigDecimal("0.50"));
        String expected = "Hubba BUBBA";
        String actual = gum.getName();
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void test_for_slot(){
        Gum gum = new Gum("D4","Hubba BUBBA", new BigDecimal("0.50"));
        String expected = "D4";
        String actual = gum.getSlot();
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void test_for_getPrice(){
        Gum gum = new Gum("D4","Hubba BUBBA", new BigDecimal("0.50"));
        String expected = "0.50";
        String actual = String.valueOf(gum.getPrice());
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void test_for_getQuantity(){
        Gum gum = new Gum("D4","Hubba BUBBA", new BigDecimal("0.50"));
        int expected = 5;
        int actual = gum.getQuantity();
        Assert.assertEquals(expected, actual);
    }

}