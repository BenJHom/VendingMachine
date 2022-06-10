package com.techelevator;

public class Drink extends Snack{


    public Drink(String name, int price, String subcategory, String priceAsADouble) {
        super(name, price, subcategory, priceAsADouble);
    }

    @Override
    public String getMessage()
    {
        return "Glug Glug, Yum!";
    }
}
