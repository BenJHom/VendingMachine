package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MoneyTest {
    private Money sut;

    @Before
    public void Init(){
        sut = new Money(new LogFile(), new Inventory());
    }

    @Test
    public void addMoneyTests(){
        int testOne = 1;
        int expectedOne = 100;
        int testTwo = 5000;
        int expectedTwo = 500100;
        int testThree = 0;
        int expectedThree = 500100;

        int actualOne = sut.addMoney(testOne);
        int actualTwo = sut.addMoney(testTwo);
        int actualThree = sut.addMoney(testThree);

        Assert.assertEquals(expectedOne,actualOne);
        Assert.assertEquals(expectedTwo,actualTwo);
        Assert.assertEquals(expectedThree,actualThree);
    }

    @Test
    public void subtractMoneyTests(){
        int testIntOne = 175;
        boolean testBoolOne = false;
        String testStrOne = "B2";
        int expectedOne = -175;
        int testIntTwo = 0;
        boolean testBoolTwo = false;
        String testStrTwo = "A3";
        int expectedTwo = -175;
        int testIntThree = 200;
        boolean testBoolThree = true;
        String testStrThree = "D4";

        int actualOne = sut.subtractMoney(testIntOne, testBoolOne, testStrOne);
        int actualTwo = sut.subtractMoney(testIntTwo, testBoolTwo, testStrTwo);
        int actualThree = sut.subtractMoney(testIntThree,testBoolThree,testStrThree);

        Assert.assertEquals(expectedOne, actualOne);
    }

    @Test
    public void getChangeInCoinsTests(){
        sut.addMoney(10);
        int[] expectedOne = {40,0,0};
        int[] passOne = sut.getChangeInCoins();
        int[] actualOne = new int[3];
        for (int i=0; i<actualOne.length; i++){
            actualOne[i] = passOne[i];
        }

        sut.subtractMoney(110, true, "A1");
        int[] expectedTwo = {-4,-1,0};
        int[] passTwo = sut.getChangeInCoins();
        int[] actualTwo = new int[3];
        for (int i=0; i<actualOne.length; i++){
            actualTwo[i] = passOne[i];
        }


        sut.subtractMoney(95, true, "D4");
        int[] expectedThree = {-3,-2,0};
        int[] actualThree = sut.getChangeInCoins();

        Assert.assertArrayEquals(expectedOne, actualOne);
        Assert.assertArrayEquals(expectedTwo,actualTwo);
        Assert.assertArrayEquals(expectedThree,actualThree);
    }
}
