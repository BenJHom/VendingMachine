package com.techelevator;

public class Money {
    private int currentAmount;
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
        this.currentAmount = currentAmount + userMoneyInPennies;
        logFile.logFeedMoney(userMoneyInPennies, currentAmount);
        return currentAmount;
    }

    public int subtractMoney(int monetaryAmount, boolean isPurchase, String userKey){
        currentAmount = currentAmount - monetaryAmount;
        if(isPurchase){
            logFile.logPurchase(inventory.getSnackList().get(userKey), userKey, currentAmount);
        }else{
            logFile.logChangeMade(monetaryAmount, currentAmount);
        }
        return currentAmount;
    }

    public int[] getChangeInCoins() {
        boolean isPurchase = false;
        int modifiedCurrent = currentAmount;

        for (int i = 0; i < changeInCoins.length; i++){
            changeInCoins[i] = modifiedCurrent/coinValues[i];
            modifiedCurrent = modifiedCurrent%coinValues[i];
        }

        subtractMoney(currentAmount, isPurchase, "");

        return changeInCoins;
    }

    public boolean makeChange(){
        return true;
    }
}
