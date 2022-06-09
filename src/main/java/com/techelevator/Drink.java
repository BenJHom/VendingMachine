package com.techelevator;

public class Drink extends Snack{

    public Drink(String name, int price, String subcategory) {
        super(name, price, subcategory);
    }

    @Override
    public String getMessage()
    {
        return "Glug Glug, Yum!";
    }
}
