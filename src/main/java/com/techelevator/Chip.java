package com.techelevator;

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
