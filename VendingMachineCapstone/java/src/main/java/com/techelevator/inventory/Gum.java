package com.techelevator.inventory;

import java.math.BigDecimal;

public class Gum extends Products {
    public Gum(String slot, String name, BigDecimal price) {
        super(slot, name, price);
    }

    @Override
    public String messageReturned() {
        return TEXT_GREEN + "\r\nChew Chew, Yum!" + TEXT_RESET;
    }
}
