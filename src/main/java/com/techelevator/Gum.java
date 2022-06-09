package com.techelevator;

public class Gum extends Snack{
    public Gum(String name, int price, String subcategory) {
        super(name, price, subcategory);
    }

    @Override
    public String getMessage()
    {
        return "Chew Chew, Yum!";
    }
}
