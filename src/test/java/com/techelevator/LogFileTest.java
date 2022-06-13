package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class LogFileTest {
    private LogFile sut;
    File logFile = new File("Log.txt");
    private Gum testGum;
    private Chip testChip;
    public String dateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("MM/dd/yyyy h:mm:ss a"));
    private Scanner testScanner;

    @Before
    public void Init(){
        sut = new LogFile();
        testGum = new Gum("TESTGUM", "Gum", "1.05");
        testChip = new Chip("TESTCHIP", "Chip", "3.00");
    }

    @Test
    public void formatMoneyTest(){
        int testOne = 0;
        String expectedOne = "$0.00";
        int testTwo = 100;
        String expectedTwo = "$1.00";
        int testThree = 2255;
        String expectedThree = "$22.55";

        String actualOne = sut.formatMoney(testOne);
        String actualTwo = sut.formatMoney(testTwo);
        String actualThree = sut.formatMoney(testThree);

        Assert.assertEquals(expectedOne,actualOne);
        Assert.assertEquals(expectedTwo,actualTwo);
        Assert.assertEquals(expectedThree,actualThree);
    }

    @Test
    public void logFeedMoneyTests(){
        int testIntOne = 0;
        int testAmountOne = 1000;
        String expectedOne = dateTime + " FEED MONEY: $0.00 $10.00";
        int testIntTwo = 500;
        int testAmountTwo = 500;
        String expectedTwo = dateTime + " FEED MONEY: $5.00 $5.00";

        String actualOne = sut.logFeedMoney(testIntOne,testAmountOne);
        String actualTwo = sut.logFeedMoney(testIntTwo,testAmountTwo);

        Assert.assertEquals(expectedOne,actualOne);
        Assert.assertEquals(expectedTwo,actualTwo);
    }

    @Test
    public void logPurchaseTests(){
        Snack testSnackOne = testChip;
        String testStrOne = "D3";
        int testIntOne = 325;
        String expectedOne = dateTime + " TESTCHIP D3 $3.00 $3.25";

        String actualOne = sut.logPurchase(testSnackOne, testStrOne, testIntOne);

        Assert.assertEquals(expectedOne, actualOne);
    }

    @Test
    public void logChangeMadeTests(){
        int testChangeOne = 675;
        int testCurrentOne = 0;
        String expectedOne = dateTime + " GIVE CHANGE: $6.75 $0.00";

        String actualOne = sut.logChangeMade(testChangeOne, testCurrentOne);

        Assert.assertEquals(expectedOne,actualOne);
    }

    @Test
    public void logWriteTests(){
        String testOne = "Blue bugs suck blue blood";
        String expected = "Blue bugs suck blue blood";

        sut.logWrite(testOne);
        sut.endStream();
        String actual = "";
        try{
            testScanner = new Scanner(logFile);
            actual = testScanner.nextLine();
        }catch(Exception e){
            System.out.println("Didn't pass");
        }

        Assert.assertEquals(expected,actual);
    }
}
