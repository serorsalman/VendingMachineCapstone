package com.techelevator.inventory;

import java.math.BigDecimal;

public abstract class Products {
    private String name;
    private BigDecimal price;
    private String slot;
    private int quantity = 5;

    public Products(String slot, String name, BigDecimal price) {
        this.name = name;
        this.price = price;
        this.slot = slot;
    }

    public Products(String slot) {
        this.slot = slot;
    }

    public String getSlot() {
        return slot;
    }

    public void setSlot(String slot) {
        this.slot = slot;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity() {
        quantity--;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return slot + " " + name + " " + price + " " + quantity;
    }

    public abstract String messageReturned();

    public static final String TEXT_RESET = "\u001B[0m";
    public static final String TEXT_GREEN = "\u001B[32m";
}
