package com.techelevator;

public class Snack {
    private int amountLeft;
    private String name;
    private int price;
    private String subcategory;
    private String priceAsAString;

    /*

     */
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
