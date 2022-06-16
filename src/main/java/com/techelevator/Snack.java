package com.techelevator;

/*
    -Snack parent class. Child classes are Chip, Candy, Drink, and Gum. Those classes will override the getMessage method
    to return a string that corresponds to each category.
 */

import java.util.Objects;

public abstract class Snack {
    private int amountLeft;
    private String name;
    private int price;
    private String subcategory;
    private String priceAsAString;

    public Snack(String name, String subcategory, String priceAsAString) {
        this.name = name;
        this.subcategory = subcategory;
        amountLeft = 5;
        this.priceAsAString = priceAsAString;
    }

    public String getMessage()
    {
        return "Generic tasty treat I guess?";
    }

    public int getAmountLeft()
    {
        return amountLeft;
    }

    public String getName() {
        return name;
    }

    //-This method changes the price from a string to an int. All the prices are in pennies, so, $3.05 will return 305

    public int getPrice() {
        price = (int)(Double.parseDouble(priceAsAString) * 100);
        return price;
    }

    public String getSubcategory() {
        return subcategory;
    }

    public String getPriceAsAString() {
        return priceAsAString;
    }

    public void setAmountLeft() {
        if(amountLeft > 0)
        {
            amountLeft--;
        }
    }
    //Overrode the both the equals and hashcode methods so that the
    //    Snack object will be compatible with HashMaps
    @Override
    public boolean equals(Object o) {
        Snack snack = (Snack) o;
        if(snack.getSubcategory().equals(subcategory))
        {
            if(snack.getName().equals(name))
            {
                if(snack.getPrice() == getPrice())
                {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, subcategory);
    }
}
