package com.techelevator;

import java.io.*;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

/*
    -This class is responsible for keeping track of sales of individual items sold. It uses a Map<Snack, Integer> where the key
    is the snack object and the value is the amount sold. It was important to make the key for the map the snack object in order
    to keep the pricing information, having String values would not have retained that information.
    -This class updates the map each time the vending machine dispenses a snack, and when the vending machine is shut down, this class
    creates a file if the user selects a hidden input
 */
public class SalesReport {


    private Map<Snack, Integer> report = new HashMap<>();
    int total;
    private String dateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("MM_dd_yyyy h_m_ss a"))+" sales report.txt";

    public void addToReport(Snack snack)
    {
        if(report.containsKey(snack))
        {
            report.put(snack, report.get(snack)+1);
        }
        else
        {
            report.put(snack, 1);
        }
    }

    public String getDateTime() {
        return dateTime;
    }

    public int getTotal()
    {
        Set<Snack> snacks = report.keySet();
        total = 0;
        for(Snack snack : snacks)
        {
            total += snack.getPrice() * report.get(snack);
        }
        return total;
    }

    public void writeToReportFile()
    {
        File newFile = new File(dateTime);
        try(PrintWriter fW = new PrintWriter(newFile))
        {
            Set<Snack> snacks = report.keySet();
            for(Snack snack : snacks)
            {
                fW.append(snack.getName() + " | "+report.get(snack)+"\n");
            }
            fW.append("\n");
            double sales = getTotal() / 100.0;
            DecimalFormat formater = new DecimalFormat("$###.00");
            fW.append("**Total Sales**: "+formater.format(sales));
        }catch(IOException e)
        {
            System.out.println("Unable to write to file");
            e.printStackTrace();
        }
    }
}
