package com.techelevator.user;

import com.techelevator.inventory.InventoryReader;
import com.techelevator.inventory.Logger;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class User {
    private static BigDecimal balance = BigDecimal.valueOf(0.00);

    InventoryReader inventoryReader = new InventoryReader();

    public User(BigDecimal balance) {
        this.balance = balance;
    }

    public User() { }

    public static BigDecimal addToBalance(BigDecimal moneySubmitted) {
        return balance = balance.add(moneySubmitted);
    }

    public static BigDecimal removeFromBalance(BigDecimal moneySubmitted) {
        return balance = balance.subtract(moneySubmitted);
    }

    public static BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public String returnChange(BigDecimal balance) {
        int quarterCount = 0;
        int dimeCount = 0;
        int nickelCount = 0;
        String changeReturned = "";
        while (balance.compareTo(new BigDecimal("0")) > 0) {
            if (balance.compareTo(new BigDecimal("0.25")) >= 0) {
                balance = balance.subtract(new BigDecimal("0.25"));
                quarterCount++;
            } else if (balance.compareTo(new BigDecimal("0.10")) >= 0) {
                balance = balance.subtract(new BigDecimal("0.10"));
                dimeCount++;

            } else if (balance.compareTo(new BigDecimal("0.05")) >= 0) {
                balance = balance.subtract(new BigDecimal("0.05"));
                nickelCount++;

            }
            changeReturned = ("\n Your change is: " + quarterCount + " Quarter(s), " + dimeCount + " Dime(s), "
                    + nickelCount + " Nickel(s) " + "Your new balance is: $ " + balance);

        }

        return changeReturned;
    }
}
