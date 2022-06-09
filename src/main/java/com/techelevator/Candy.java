package com.techelevator;

public class Candy extends Snack{

    public Candy(String name, int price, String subcategory) {
        super(name, price, subcategory);
    }

    @Override
    public String getMessage() {
        return "Munch Munch, Yum!";
    }
}
