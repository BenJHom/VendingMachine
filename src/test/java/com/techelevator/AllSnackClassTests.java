package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class AllSnackClassTests {
    public Snack sut;

    @Test
    public void get_chip_message()
    {
        sut = new Chip("Stackers",  "chips", "3.05");
        Assert.assertEquals("Crunch Crunch, Yum!", sut.getMessage());
    }

    @Test
    public void get_drink_message()
    {
        sut = new Drink("Stackers", "chips", "3.05");
        Assert.assertEquals( "Glug Glug, Yum!", sut.getMessage());
    }

    @Test
    public void get_candy_message()
    {
        sut = new Candy("Stackers", "chips", "3.05");
        Assert.assertEquals("Munch Munch, Yum!", sut.getMessage());
    }

    @Test
    public void get_gum_message()
    {
        sut = new Gum("Stackers",  "chips", "3.05");
        Assert.assertEquals("Chew Chew, Yum!", sut.getMessage());
    }

    @Test
    public void get_gum_amount_left()
    {
        sut = new Gum("Stackers",  "chips", "3.05");
        sut.setAmountLeft();
        Assert.assertEquals(4, sut.getAmountLeft());
        sut.setAmountLeft();
        Assert.assertEquals(3, sut.getAmountLeft());
        sut.setAmountLeft();
        Assert.assertEquals(2, sut.getAmountLeft());
        sut.setAmountLeft();
        Assert.assertEquals(1, sut.getAmountLeft());
        sut.setAmountLeft();
        Assert.assertEquals(0, sut.getAmountLeft());
        sut.setAmountLeft();
        Assert.assertEquals(0, sut.getAmountLeft());
    }
}
