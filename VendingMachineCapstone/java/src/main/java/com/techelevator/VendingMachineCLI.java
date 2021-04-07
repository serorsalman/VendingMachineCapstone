package com.techelevator;

import com.techelevator.inventory.InventoryReader;
import com.techelevator.inventory.Logger;
import com.techelevator.inventory.Products;
import com.techelevator.user.Cart;
import com.techelevator.user.User;
import com.techelevator.view.Menu;

import java.awt.*;
import java.beans.beancontext.BeanContext;
import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;
import java.io.IOException;
import java.util.*;

public class VendingMachineCLI {

    private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
    private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
    private static final String PURCHASE_MENU_OPTION_FEED_MONEY = "Feed Money";
    private static final String PURCHASE_MENU_OPTION_SELECT_PRODUCT = "Select Product";
    private static final String PURCHASE_MENU_OPTION_FINISH_TRANSACTION = "Finish Transaction";
    private static final String[] MAIN_MENU_OPTIONS = {MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE};
    private static final String[] PURCHASE_MENU_OPTIONS = {PURCHASE_MENU_OPTION_FEED_MONEY, PURCHASE_MENU_OPTION_SELECT_PRODUCT, PURCHASE_MENU_OPTION_FINISH_TRANSACTION};
    public static final String TEXT_RESET = "\u001B[0m";
    public static final String TEXT_RED = "\u001B[31m";
    public static final String TEXT_YELLOW = "\u001B[33m";


    private Menu menu;
    Scanner userInput = new Scanner(System.in);
    User user = new User(new BigDecimal(0.00));
    Cart cart = new Cart();
    Logger logger = new Logger();

    public VendingMachineCLI(Menu menu) {
        this.menu = menu;
    }

    public void run() throws IOException {// think of this like the main
        InventoryReader inventoryReader = new InventoryReader();
        List<Products> vendingList = inventoryReader.inventoryImport();
        while (true) {
            String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

            if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
                // display vending machine items
                for (Products product : vendingList) {
                    System.out.println(product);
                }

            } else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
                // do purchase
                while (true) {
                    System.out.println("\r\nCurrent Money Provided: $" + user.getBalance());
                    String userChoice = (String) menu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS);
                    if (userChoice.equals(PURCHASE_MENU_OPTION_FEED_MONEY)) {
                        System.out.println("Current Money Provided: $" + user.getBalance());
                        while (true) {
                            System.out.println("Please insert cash: (Accepts only $1, $2, $5, or $10)");

                            String line = userInput.nextLine();

                            boolean isValidBill = line.equals("1") || line.equals("2") || line.equals("5") || line.equals("10");

                            if (!isValidBill) {
                                System.out.println(TEXT_RED +"pleased add a valid bill!!" + TEXT_RESET);
                                continue;
                            }

                            BigDecimal moneyIn = new BigDecimal(line);

                            BigDecimal balance = user.getBalance();
                            balance = User.addToBalance(moneyIn);
                            logger.logToFile("FEED MONEY", moneyIn, user.getBalance());
                            System.out.println("Current Money Provided: $" + balance);


                            System.out.println(TEXT_YELLOW + "Would you like to add additional funds? " + TEXT_RESET + "(Y/N)");
                            String continueChoice = userInput.nextLine();
                            if (!continueChoice.equalsIgnoreCase("Y")) {
                                break;
                            }
                        }
                    } else if (userChoice.equals(PURCHASE_MENU_OPTION_SELECT_PRODUCT)) {
                        for (Products product : vendingList) {
                            System.out.println(product);
                        }
                        System.out.print(TEXT_YELLOW + "Choose an item: " + TEXT_RESET);
                        String slotChoice = userInput.nextLine();
                        BigDecimal vendorBalance = new BigDecimal(String.valueOf(user.getBalance()));

                        boolean foundIt = false;

                        for (int i = 0; i < vendingList.size(); i++) {
                            if (vendingList.get(i).getSlot().equals(slotChoice.toUpperCase())) {
                                int hasMoneyCheck = vendorBalance.compareTo(vendingList.get(i).getPrice());
                                if (hasMoneyCheck == -1) {
                                    System.out.println(TEXT_RED + "You do not have enough funds available" + TEXT_RESET);
                                    foundIt = true;
                                    break;
                                } else if (vendingList.get(i).getQuantity() == 0) {
                                    System.out.println(TEXT_RED + "SOLD OUT" + TEXT_RESET);
                                    break;
                                } else {
                                    vendingList.get(i).setQuantity();
                                    user.removeFromBalance(vendingList.get(i).getPrice());
                                    cart.addToCart(vendingList.get(i));
                                    logger.logToFile(String.valueOf(vendingList.get(i)), user.getBalance(), vendorBalance);
                                    System.out.println(vendingList.get(i).messageReturned());
                                }
                                foundIt = true;
                                break;
                            }
                        }
                        if (!foundIt) {
                            System.out.println(TEXT_YELLOW + "Please choose a valid product ID" + TEXT_RESET);
                        }

                    } else if (userChoice.equals(PURCHASE_MENU_OPTION_FINISH_TRANSACTION)) {
                        System.out.println(user.returnChange(user.getBalance()));
                        user.setBalance(BigDecimal.valueOf(0.00));
                        logger.logToFile("GIVE CHANGE", user.getBalance(), BigDecimal.valueOf(0.00));
//                        System.out.println(userCart);
                        break;
                    }
                }
            }
        }

    }

    public static void main(String[] args) throws ArrayIndexOutOfBoundsException, IOException {
        Menu menu = new Menu(System.in, System.out);
        VendingMachineCLI cli = new VendingMachineCLI(menu);
        cli.run();
    }
}
