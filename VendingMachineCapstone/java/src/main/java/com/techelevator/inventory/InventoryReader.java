package com.techelevator.inventory;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.*;

public class InventoryReader {


    public List<Products> inventoryImport() {
        File inventoryCSV = new File("vendingmachine.csv");
        int counter = 0;
        List<Products> productsList = new ArrayList<>();

        try (Scanner inventoryReader = new Scanner(inventoryCSV)) {

            while (inventoryReader.hasNextLine()) {
                String line = inventoryReader.nextLine();
                String lineArray[] = line.split("\\|");
                counter++;

                if (lineArray[3].contains("Chip")) {
                    productsList.add(new Chips(lineArray[0], lineArray[1], new BigDecimal(lineArray[2])));
                } else if (lineArray[3].contains("Candy")) {
                    productsList.add(new Candy(lineArray[0], lineArray[1], new BigDecimal(lineArray[2])));
                } else if (lineArray[3].contains("Drink")) {
                    productsList.add(new Drinks(lineArray[0], lineArray[1], new BigDecimal(lineArray[2])));
                } else if (lineArray[3].contains("Gum")) {
                    productsList.add(new Gum(lineArray[0], lineArray[1], new BigDecimal(lineArray[2])));
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return productsList;
    }

}

