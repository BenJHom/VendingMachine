package com.techelevator;

public class Gum extends Snack{


    public Gum(String name, int price, String subcategory, String priceAsADouble) {
        super(name, price, subcategory, priceAsADouble);
    }

    @Override
    public String getMessage()
    {
        return "Chew Chew, Yum!";
    }
}
