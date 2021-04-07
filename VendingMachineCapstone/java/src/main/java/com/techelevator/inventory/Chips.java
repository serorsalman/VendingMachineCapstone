package com.techelevator.inventory;

import java.math.BigDecimal;

public class Chips extends Products {

    public Chips(String slot, String name, BigDecimal price) {
        super(slot, name, price);
    }

    @Override
    public String messageReturned() {
        return TEXT_GREEN + "\r\nCrunch Crunch, Yum!" + TEXT_RESET;
    }
}
