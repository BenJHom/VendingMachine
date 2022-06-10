package com.techelevator;

public class Candy extends Snack{


    public Candy(String name, String subcategory, String priceAsADouble) {
        super(name, subcategory, priceAsADouble);
    }

    @Override
    public String getMessage() {
        return "Munch Munch, Yum!";
    }
}
