package com.techelevator;

    /*
    Snack subclass, purely meant to override the getMessage() method
     */

public class Drink extends Snack{

    public Drink(String name, String subcategory, String priceAsADouble) {
        super(name, subcategory, priceAsADouble);
    }

    @Override
    public String getMessage()
    {
        return "Glug Glug, Yum!";
    }
}
