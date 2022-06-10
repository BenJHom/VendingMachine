package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

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
