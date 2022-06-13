package com.techelevator;

import java.io.File;
import java.io.PrintWriter;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class LogFile {
    File logFile;
    Inventory inventory;
    public String dateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("MM/dd/yyyy h:mm:ss a"));
    public PrintWriter fileLogger = null;

    public LogFile() {
        logFile = new File("Log.txt");
        try {
            fileLogger = new PrintWriter(logFile);
        }
        catch (Exception e) {
            System.out.println("Not a valid location");
        }
    }

    public String formatMoney(int monetaryAmount){
        int ones = monetaryAmount/100;
        int cents = monetaryAmount%100;
        return "$" + ones + "." + (cents < 10 ? 0 : "") + cents;
    }

    public String logFeedMoney(int userMoneyInPennies, int currentAmount){
        String formattedCurrent = formatMoney(currentAmount);
        String formattedFeed = formatMoney(userMoneyInPennies);
        String logOfFeed = dateTime + " FEED MONEY: " + formattedFeed + " " + formattedCurrent;
        logWrite(logOfFeed);
        return logOfFeed;
    }

    public String logPurchase(Snack snack, String userKey, int currentAmount){
        String formattedPrice = formatMoney(snack.getPrice());
        String formattedCurrent = formatMoney(currentAmount);
        String logOfPurchase = dateTime + " " + snack.getName() + " " + userKey + " " + formattedPrice + " " + formattedCurrent;
        logWrite(logOfPurchase);
        return logOfPurchase;
    }

    public String logChangeMade(int monetaryAmount, int currentAmount){
        String formattedChangeGiven = formatMoney(monetaryAmount);
        String formattedCurrent = formatMoney(currentAmount);
        String logOfChangeMade = dateTime+ " GIVE CHANGE: " + formattedChangeGiven + " " + formattedCurrent;
        logWrite(logOfChangeMade);
        return logOfChangeMade;
    }

    public void logWrite(String logString) {
            fileLogger.println(logString);
    }

    public boolean endStream(){
        fileLogger.flush();
        fileLogger.close();
        return true;
    }
}

