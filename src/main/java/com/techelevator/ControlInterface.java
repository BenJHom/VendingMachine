package com.techelevator;

import java.util.Scanner;
import java.util.Set;

public class ControlInterface {
    public Money money = new Money();
    private Scanner keyboard = new Scanner (System.in);
    LogFile logFile = new LogFile();
    public Inventory inventory = new Inventory();

    public ControlInterface(){

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
            purchaseMenu();
        }else {
            mainMenuDisplay(true);
        }
    }

    //MAIN MENU POST SELECTION

    private boolean printInventoryItems(){
        System.out.println("At Inventory Items");
        Set<String> keySet = inventory.getSnackList().keySet();
        for(String key : keySet)
        {
            double backToDecimal = inventory.getSnackList().get(key).getPrice() / 100.0;
            System.out.println("Item: "+inventory.getSnackList().get(key).getName()+ " Price: "+backToDecimal);
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

    private boolean selectProduct(){
        boolean isPurchase = true;
        printInventoryItems();
        System.out.print("Enter the item code for the corresponding snack: ");
        String userKey = keyboard.nextLine();
        inventory.dispenseSnack(userKey);
        money.subtractMoney(iventory.getSnackList().get(userKey).getPrice(),isPurchase);

        return inventory.dispenseSnack();
    }

    private void finishTransaction(){
        String[] coins = {" quarters", " dimes", " nickels"};
        money.makeChange();
        System.out.println("Your change: ");
        for (int i = 0; i< coins.length; i++){
            System.out.println(money.getChangeInCoins()[i] + coins[i]);
        }
        mainMenuDisplay(true);
    }
}
