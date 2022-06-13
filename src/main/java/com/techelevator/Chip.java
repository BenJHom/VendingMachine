package com.techelevator;

    /*
    Snack subclass, purely meant to override the getMessage() method
     */

public class Chip extends Snack{


    public Chip(String name, String subcategory, String priceAsADouble) {
        super(name, subcategory, priceAsADouble);
    }

    @Override
    public String getMessage()
    {
        return "Crunch Crunch, Yum!";
    }
}
