package com.techelevator;

public class Gum extends Snack{


    public Gum(String name, String subcategory, String priceAsADouble) {
        super(name, subcategory, priceAsADouble);
    }

    @Override
    public String getMessage()
    {
        return "Chew Chew, Yum!";
    }
}
