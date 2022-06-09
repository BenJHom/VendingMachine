package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Inventory {

    private Map<String, Snack> snackList;


    public Inventory()
    {
        snackList = new LinkedHashMap<>();
        importSnacksFromList();
    }

    public Map<String, Snack> getSnackList()
    {

        return snackList;
    }

    public void importSnacksFromList()
    {
        File fileName = new File("vendingmachine.csv");
        try(Scanner reader = new Scanner(fileName))
        {
            while(reader.hasNextLine())
            {
                putImportsInMap(reader.nextLine());
            }
        }catch (FileNotFoundException e)
        {
            e.getStackTrace();
        }
    }

    private void putImportsInMap(String fileInput)
    {
        String[] fileElements = fileInput.split("\\|");
        Snack newSnack = null;
        int priceAsInt = (int)(Double.parseDouble(fileElements[2]) * 100);
        switch(fileElements[3]){
            case ("Chip"):
                newSnack = new Chip(fileElements[1], priceAsInt, fileElements[3]);
                break;
            case ("Drink"):
                newSnack = new Drink(fileElements[1], priceAsInt, fileElements[3]);
                break;
            case ("Gum"):
                newSnack = new Gum(fileElements[1], priceAsInt, fileElements[3]);
                break;
            case ("Candy"):
                newSnack = new Candy(fileElements[1], priceAsInt, fileElements[3]);
                break;
        }
        snackList.put(fileElements[0], newSnack);
    }

    public Snack dispenseSnack(String location)
    {
        snackList.get(location).setAmountLeft();
        return snackList.get(location);

    }
}
