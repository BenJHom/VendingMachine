package com.techelevator;

public class Money {
    private int currentAmount = 0;
    private int[] changeInCoins = new int[3];
    private int[] coinValues = {25, 10, 5};
    private LogFile logFile;
    private Inventory inventory;

    public Money(LogFile logFile, Inventory inventory){
        this.logFile = logFile;
        this.inventory = inventory;
    }

    public int getCurrentAmount() {
        return currentAmount;
    }

    public int addMoney(int userMoney) {
        int userMoneyInPennies = 100 * userMoney;
        this.currentAmount += userMoneyInPennies;
        logFile.logFeedMoney(userMoneyInPennies);
        return currentAmount;
    }

    public int subtractMoney(int monetaryAmount, boolean isPurchase, String userKey){
        currentAmount = currentAmount - monetaryAmount;
        if(isPurchase){
            logFile.logPurchase(inventory.getSnackList().get(userKey), userKey);
        }else{
            logFile.logChangeMade(monetaryAmount);
        }
        return currentAmount;
    }

    public int[] getChangeInCoins() {
        boolean isPurchase = false;

        for (int i = 0; i < changeInCoins.length; i++){
            changeInCoins[i] = currentAmount/coinValues[i];
            currentAmount = currentAmount%coinValues[i];
        }

        subtractMoney(currentAmount, isPurchase, "");

        return changeInCoins;
    }

    public boolean makeChange(){
        return true;
    }
}
