package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class InventoryTests {
    private Inventory sut;

    @Before
    public void setup()
    {
        sut = new Inventory();
    }

    @Test
    public void check_for_drinks()
    {
        Assert.assertEquals("Mountain Melter", sut.getSnackList().get("C3").getName());
        Assert.assertEquals("Glug Glug, Yum!", sut.getSnackList().get("C1").getMessage());

    }

    @Test
    public void check_for_chips()
    {
        Assert.assertEquals("Grain Waves", sut.getSnackList().get("A3").getName());
        Assert.assertEquals("Crunch Crunch, Yum!", sut.getSnackList().get("A1").getMessage());
    }

    @Test
    public void check_for_candy()
    {
        Assert.assertEquals("Wonka Bar", sut.getSnackList().get("B3").getName());
        Assert.assertEquals("Munch Munch, Yum!", sut.getSnackList().get("B1").getMessage());
    }

    @Test
    public void check_for_gum()
    {
        Assert.assertEquals("Chiclets", sut.getSnackList().get("D3").getName());
        Assert.assertEquals("Chew Chew, Yum!", sut.getSnackList().get("D1").getMessage());
    }

    @Test
    public void test_dispense_snack()
    {
        String input = "C1";
        sut.dispenseSnack(input);
        Assert.assertEquals(4, sut.getSnackList().get(input).getAmountLeft());
        sut.dispenseSnack(input);
        Assert.assertEquals(3, sut.getSnackList().get(input).getAmountLeft());
        sut.dispenseSnack(input);
        Assert.assertEquals(2, sut.getSnackList().get(input).getAmountLeft());
        sut.dispenseSnack(input);
        Assert.assertEquals(1, sut.getSnackList().get(input).getAmountLeft());
        sut.dispenseSnack(input);
        Assert.assertEquals(0, sut.getSnackList().get(input).getAmountLeft());
        sut.dispenseSnack(input);
        Assert.assertEquals(0, sut.getSnackList().get(input).getAmountLeft());
    }
}
