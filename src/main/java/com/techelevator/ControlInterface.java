package com.techelevator;

import java.util.Scanner;
import java.util.Set;

public class ControlInterface {
    public LogFile logFile;
    private Scanner keyboard = new Scanner (System.in);
    public Inventory inventory = new Inventory();
    public Money money;

    public ControlInterface(){
        logFile = new LogFile(money);
        money = new Money(logFile,inventory);
    }

    private int dataValidatorInt(int upperBound){
        int userInput = 0;
        System.out.print(">>> ");
        String userInputStr = keyboard.nextLine();
        try{
            userInput = Integer.parseInt(userInputStr);
            if (userInput < 1 || userInput > upperBound){
                throw new Exception();
            }
        }catch (Exception e){
            System.out.println("Enter 1-" + upperBound);
            userInput = dataValidatorInt(upperBound);
        }
        return userInput;
    }

    public void mainMenuDisplay(boolean runsProperly){
        int userInput = 0;

        System.out.println("(1) Display Vending Maching Items");
        System.out.println("(2) Purchase");
        System.out.println("(3) Exit");

        userSelector(dataValidatorInt(3));
    }


    //SELECTOR METHODS
    private void userSelector(int userInput){
        if (userInput == 1) {
            mainMenuDisplay(printInventoryItems());
        }else if(userInput == 2) {
            purchaseMenu();
        }else {
            exitLogFile();
        }
    }

    private void userSelectorPurchaseMenu(int userInput){
        if (userInput == 1) {
            feedMoney(money);
        }else if(userInput == 2) {
            //purchaseMenu();
            selectProduct();
        }else {
            //mainMenuDisplay(true);
            finishTransaction();
        }
    }

    //MAIN MENU POST SELECTION

    private boolean printInventoryItems(){
        System.out.println("At Inventory Items");
        Set<String> keySet = inventory.getSnackList().keySet();
        for(String key : keySet)
        {
            if(inventory.getSnackList().get(key).getAmountLeft() > 0) {
                int priceInDollars = inventory.getSnackList().get(key).getPrice() / 100;
                int priceInCents = inventory.getSnackList().get(key).getPrice() % 100;
                System.out.println("Item Code: " + key + " >>> Item: " + inventory.getSnackList().get(key).getName() + " >>> Price: $" + priceInDollars + "." + priceInCents);
            }
        }
        return true;
    }

    private void purchaseMenu(){
        System.out.println("You have " + money.getCurrentAmount());
        System.out.println("(1) Feed Money");
        System.out.println("(2) Select Product");
        System.out.println("(3) Finish Transaction");

        int userInput = dataValidatorInt(3);
        userSelectorPurchaseMenu(userInput);
    }

    private String exitLogFile(){
        String logFilePath = "";
        System.out.println("At Exit");
        return logFilePath;
    }

    //PURCHASE MENU POST SELECTOR
    private void feedMoney(Money money){
        System.out.println("Please enter a monetary amount: ");
        int userMoney = dataValidatorInt(Integer.MAX_VALUE/100);
        money.addMoney(userMoney);
        purchaseMenu();
    }

    private void selectProduct(){
        boolean isPurchase = true;
        printInventoryItems();
        String userKey;
        do {
            System.out.print("Enter the item code for the corresponding snack: ");
            userKey = keyboard.nextLine();
            if (!inventory.getSnackList().containsKey(userKey)){
                System.out.println("That's not a valid code");
            }
            if(!(inventory.getSnackList().get(userKey).getAmountLeft()>0)){
                System.out.println("Item out of stock!  Sorry, please select another item.");
            }
        }
        while (!inventory.getSnackList().containsKey(userKey) || !(inventory.getSnackList().get(userKey).getAmountLeft()>0));
        System.out.println(inventory.dispenseSnack(userKey).getMessage());
        money.subtractMoney(inventory.getSnackList().get(userKey).getPrice(),isPurchase, userKey);
        purchaseMenu();
    }

    private void finishTransaction(){
        String[] coins = {" quarters", " dimes", " nickels"};
        int[] changeInCoins = money.getChangeInCoins();
        money.makeChange();
        System.out.println("Your change: ");
        for (int i = 0; i< coins.length; i++){
            System.out.println(changeInCoins[i] + coins[i]);
        }
        mainMenuDisplay(true);
    }
}
