package com.techelevator;

    /*
    Snack subclass, purely meant to override the getMessage() method
     */

public class Candy extends Snack{


    public Candy(String name, String subcategory, String priceAsADouble) {
        super(name, subcategory, priceAsADouble);
    }

    @Override
    public String getMessage() {
        return "Munch Munch, Yum!";
    }
}
