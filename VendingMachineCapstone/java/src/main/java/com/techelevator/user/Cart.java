package com.techelevator.user;

import com.techelevator.inventory.Products;

import java.util.ArrayList;
import java.util.List;

public class Cart extends User {
    private List<Products> userCart = new ArrayList<>();

    public void addToCart(Products purchasedItem) {
        userCart.add(purchasedItem);
    }
}
