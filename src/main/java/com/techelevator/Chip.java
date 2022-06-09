package com.techelevator;

public class Chip extends Snack{

    public Chip(String name, int price, String subcategory) {
        super(name, price, subcategory);
    }

    @Override
    public String getMessage()
    {
        return "Crunch Crunch, Yum!";
    }
}
