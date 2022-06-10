package com.techelevator;

public class Candy extends Snack{


    public Candy(String name, int price, String subcategory, String priceAsADouble) {
        super(name, price, subcategory, priceAsADouble);
    }

    @Override
    public String getMessage() {
        return "Munch Munch, Yum!";
    }
}
