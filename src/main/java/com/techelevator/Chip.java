package com.techelevator;

public class Chip extends Snack{


    public Chip(String name, int price, String subcategory, String priceAsADouble) {
        super(name, price, subcategory, priceAsADouble);
    }

    @Override
    public String getMessage()
    {
        return "Crunch Crunch, Yum!";
    }
}
