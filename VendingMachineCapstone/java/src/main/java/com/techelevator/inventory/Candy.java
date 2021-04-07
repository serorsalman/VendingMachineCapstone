package com.techelevator.inventory;

import java.math.BigDecimal;

public class Candy extends Products {

    public Candy(String slot, String name, BigDecimal price) {
        super(slot, name, price);
    }

    @Override
    public String messageReturned() {return TEXT_GREEN + "\r\nMunch Munch, Yum!" +TEXT_RESET;
    }
}
