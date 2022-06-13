package com.techelevator;

/*
    -Snack parent class. Child classes are Chip, Candy, Drink, and Gum. Those classes will override the getMessage method
    to return a string that corresponds to each category.
 */
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

    public String getPriceAsAString() {
        return priceAsAString;
    }

    public void setAmountLeft() {
        if(amountLeft > 0)
        {
            amountLeft--;
        }
    }
}
