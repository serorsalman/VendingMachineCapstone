package com.techelevator.user;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class UserTest extends TestCase {

    @Test
    public void testAddToBalance() {
        User user = new User(new BigDecimal("3.00"));
        BigDecimal expected = new BigDecimal("6.00");
        BigDecimal actual = user.addToBalance(new BigDecimal("3.00"));
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testRemoveFromBalance() {
        User user = new User(new BigDecimal("3.00"));
        BigDecimal expected = new BigDecimal("1.50");
        BigDecimal actual = user.removeFromBalance(new BigDecimal("1.50"));
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void test_for_changeReturned() {
        User user = new User(new BigDecimal("1.00"));
        String expected = "\n Your change is: 4" + " Quarter(s), " + "0 Dime(s), "
                + "0 Nickel(s) " + "Your new balance is: $ " + "0.00";
        String actual = user.returnChange(new BigDecimal("1.00"));
        Assert.assertEquals(expected, actual);
    }
}