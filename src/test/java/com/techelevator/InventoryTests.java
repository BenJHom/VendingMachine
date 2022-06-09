package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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
}
