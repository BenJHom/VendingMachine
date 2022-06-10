package com.techelevator;

import java.io.*;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class SalesReport {


    private Map<Snack, Integer> report = new HashMap<>();
    int total;
    private String dateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("MM_dd_yyyy h_m_ss a"))+" sales report.txt";

    public Map<Snack, Integer> getReport() {
        return report;
    }

    public void addToReport(Snack snack)
    {
        boolean isInList = false;
        Set<Snack> snacks = report.keySet();
        for(Snack snackers : snacks)
        {
            if(snackers.getName().equalsIgnoreCase(snack.getName()))
            {
                int amount = report.get(snackers) + 1;
                report.replace(snackers, amount);
                isInList = true;
                break;
            }
        }
        if(!isInList)
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
