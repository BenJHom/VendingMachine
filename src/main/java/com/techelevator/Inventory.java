package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/*
    -This class is resposible for recording the inventory of the vending machine. It keeps a Map<String, Snack> where the key is the item code
    corresponding to each location, and the value is the actual snack object. The constructor imports the data from the file, so upon initializing
    an inventory object the data is already read from the file and stored into the map variable
    -This class is responsible for creating each snack object in the putImportsInMap() method
    -I decided to keep the amount left in the snack object, even though it is more a property of the inventory, than of an individual snack for ease of use.
    Keeping the amount tied to the snack object means I don't have to make and manipulate duplicate maps to know how many products are left in each location.
    -This class also initializes the SalesReport class.
 */
public class Inventory {

    private Map<String, Snack> snackList;
    SalesReport report = new SalesReport();


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
        switch(fileElements[3]){
            case ("Chip"):
                newSnack = new Chip(fileElements[1], fileElements[3], fileElements[2]);
                break;
            case ("Drink"):
                newSnack = new Drink(fileElements[1], fileElements[3], fileElements[2]);
                break;
            case ("Gum"):
                newSnack = new Gum(fileElements[1], fileElements[3], fileElements[2]);
                break;
            case ("Candy"):
                newSnack = new Candy(fileElements[1], fileElements[3], fileElements[2]);
                break;
        }
        snackList.put(fileElements[0], newSnack);
    }

    public Snack dispenseSnack(String location)
    {
        snackList.get(location).setAmountLeft();
        report.addToReport(snackList.get(location));
        return snackList.get(location);

    }

    public void salesReport()
    {
        report.writeToReportFile();
    }
}
