package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class AllSnackClassTests {
    public Snack sut;

    @Test
    public void get_chip_message()
    {
        sut = new Chip("Stackers", 2, "chips");
        Assert.assertEquals("Crunch Crunch, Yum!", sut.getMessage());
    }

    @Test
    public void get_drink_message()
    {
        sut = new Drink("Stackers", 2, "chips");
        Assert.assertEquals( "Glug Glug, Yum!", sut.getMessage());
    }

    @Test
    public void get_candy_message()
    {
        sut = new Candy("Stackers", 2, "chips");
        Assert.assertEquals("Munch Munch, Yum!", sut.getMessage());
    }

    @Test
    public void get_gum_message()
    {
        sut = new Gum("Stackers", 2, "chips");
        Assert.assertEquals("Chew Chew, Yum!", sut.getMessage());
    }

    @Test
    public void get_gum_amount_left()
    {
        sut = new Gum("Stackers", 2, "chips");
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