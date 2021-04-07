package com.techelevator.inventory;

import java.math.BigDecimal;

public class Drinks extends Products {

    public Drinks(String slot, String name, BigDecimal price) {
        super(slot, name, price);
    }

    @Override
    public String messageReturned() {
        return TEXT_GREEN + "\r\nGlug Glug, Yum!" + TEXT_RESET;
    }
}
