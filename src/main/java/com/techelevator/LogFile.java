package com.techelevator;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.sql.Date;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.time.LocalDateTime;

public class LogFile {
    File logFile;
    Money money;
    Inventory inventory;
    public String dateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("MM/dd/yyyy h:mm:ss a"));

    public LogFile(Money money) {
        logFile = new File("Log.txt");
        money = new Money(this, inventory);
    }

    public String formatMoney(int monetaryAmount){
        int ones = monetaryAmount/100;
        int cents = monetaryAmount%100;
        return ones+"."+cents;
    }

    public String logFeedMoney(int userMoneyInPennies){
        String formattedCurrent = formatMoney(money.getCurrentAmount());
        String formattedFeed = formatMoney(userMoneyInPennies);
        String logOfFeed = dateTime + " FEED MONEY: " + formattedFeed + formattedCurrent;
    }

    public String logPurchase(Snack snack){
        String formattedPrice = formatMoney(snack.getPrice());
        String formattedCurrent = formatMoney(money.getCurrentAmount());
    }

    private void logWrite(String logString) {
        try (PrintWriter fileLogger = new PrintWriter(new FileWriter(logFile,true))){
            fileLogger.append(logString);
        }catch(Exception e){
            System.out.println("Not a valid location");
        }
    }
}

