package com.techelevator;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class LogFile {
    File logFile;
    Money money;
    Inventory inventory;
    public String dateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("MM/dd/yyyy h:mm:ss a"));

    public LogFile(Money money) {
        logFile = new File("Log.txt");
        this.money = new Money(this, inventory);
    }

    public String formatMoney(int monetaryAmount){
        int ones = monetaryAmount/100;
        int cents = monetaryAmount%100;
        int centsOnes = monetaryAmount%10;
        return "$" + ones + "." + (cents < 10 ? 0 : "") + cents;
    }

    public String logFeedMoney(int userMoneyInPennies){
        String formattedCurrent = formatMoney(money.getCurrentAmount());
        String formattedFeed = formatMoney(userMoneyInPennies);
        String logOfFeed = dateTime + " FEED MONEY: " + formattedFeed + " " + formattedCurrent;
        logWrite(logOfFeed);
        return logOfFeed;
    }

    public String logPurchase(Snack snack, String userKey){
        String formattedPrice = formatMoney(snack.getPrice());
        String formattedCurrent = formatMoney(money.getCurrentAmount());
        String logOfPurchase = dateTime + " " + snack.getName() + " " + userKey + " " + formattedPrice + " " + formattedCurrent;
        logWrite(logOfPurchase);
        return logOfPurchase;
    }

    public String logChangeMade(int monetaryAmount){
        String formattedChangeGiven = formatMoney(monetaryAmount);
        String formattedCurrent = formatMoney(money.getCurrentAmount());
        String logOfChangeMade = dateTime+ " GIVE CHANGE: " + formattedChangeGiven + " " + formattedCurrent;
        logWrite(logOfChangeMade);
        return logOfChangeMade;
    }

    private void logWrite(String logString) {
        try (PrintWriter fileLogger = new PrintWriter(new FileWriter(logFile,true))){
            fileLogger.append(logString + "\n");
            System.out.println();
        }catch(Exception e){
            System.out.println("Not a valid location");
        }
    }
}

