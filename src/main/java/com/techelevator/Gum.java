package com.techelevator;

    /*
    Snack subclass, purely meant to override the getMessage() method
     */

public class Gum extends Snack{


    public Gum(String name, String subcategory, String priceAsADouble) {
        super(name, subcategory, priceAsADouble);
    }

    @Override
    public String getMessage()
    {
        return "Chew Chew, Yum!";
    }
}
