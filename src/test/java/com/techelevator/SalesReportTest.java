package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SalesReportTest {

    private SalesReport sut;
    private String snack1 = "Stickers";
    private String snack2 = "Sizzlers";
    private String snack3 = "Stackers";
    @Before
    public void setup()
    {
        sut = new SalesReport();
    }
    @Test
    public void test_for_accurate_counts()
    {
        List<String> reportData = new ArrayList<>();
        sut.addToReport(new Candy(snack3,  "chips", "3.05"));
        sut.addToReport(new Candy(snack3,  "chips", "3.05"));
        sut.addToReport(new Candy(snack3,  "chips", "3.05"));

        sut.addToReport(new Candy(snack2,  "chips", "3.05"));
        sut.addToReport(new Candy(snack2,  "chips", "3.05"));
        sut.addToReport(new Candy(snack2,  "chips", "3.05"));
        sut.addToReport(new Candy(snack2,  "chips", "3.05"));

        sut.addToReport(new Candy(snack1,  "chips", "3.05"));
        sut.addToReport(new Candy(snack1,  "chips", "3.05"));
        sut.addToReport(new Candy(snack1,  "chips", "3.05"));
        sut.addToReport(new Candy(snack1,  "chips", "3.05"));
        sut.addToReport(new Candy(snack1,  "chips", "3.05"));
        sut.addToReport(new Candy(snack1,  "chips", "3.05"));
        sut.writeToReportFile();

        try(Scanner reader = new Scanner(new File(sut.getDateTime()))) {
            while(reader.hasNextLine())
            {
                reportData.add(reader.nextLine());
                if(!reportData.get(reportData.size() - 1).contains("|"))
                {
                    reportData.remove(reportData.size() - 1);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        for(String string : reportData)
        {
            String[] splitData = string.split("\\|");
            if(splitData[0].trim().equalsIgnoreCase(snack3))
            {
                Assert.assertEquals("3", splitData[1].trim());
            }
            if(splitData[0].trim().equalsIgnoreCase(snack2))
            {
                Assert.assertEquals("4", splitData[1].trim());
            }
            if(splitData[0].trim().equalsIgnoreCase(snack1))
            {
                Assert.assertEquals("6", splitData[1].trim());
            }
        }
    }

    @Test
    public void test_for_accurate_totals1() {
        List<String> reportData = new ArrayList<>();
        sut.addToReport(new Candy(snack1,  "chips", "3.05"));
        sut.addToReport(new Candy(snack1,  "chips", "3.05"));
        sut.addToReport(new Candy(snack1,  "chips", "3.05"));

        sut.addToReport(new Candy(snack2,  "chips", "3.05"));
        sut.addToReport(new Candy(snack2,  "chips", "3.05"));
        sut.addToReport(new Candy(snack2,  "chips", "3.05"));
        sut.addToReport(new Candy(snack2,  "chips", "3.05"));

        sut.addToReport(new Candy(snack3,  "chips", "3.05"));
        sut.addToReport(new Candy(snack3,  "chips", "3.05"));
        sut.addToReport(new Candy(snack3,  "chips", "3.05"));
        sut.addToReport(new Candy(snack3,  "chips", "3.05"));
        sut.addToReport(new Candy(snack3,  "chips", "3.05"));
        sut.addToReport(new Candy(snack3,  "chips", "3.05"));
        sut.writeToReportFile();

        try (Scanner reader = new Scanner(new File(sut.getDateTime()))) {
            while (reader.hasNextLine()) {
                reportData.add(reader.nextLine());
                if (reportData.get(reportData.size() - 1).contains("|")) {
                    reportData.remove(reportData.size() - 1);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        reportData.remove(0);
        double total = Double.parseDouble(reportData.get(0).substring(18));
        Assert.assertEquals(39.65, total, 0.01);
    }

    @Test
    public void test_for_accurate_totals() {
        List<String> reportData = new ArrayList<>();
        sut.addToReport(new Candy(snack1, "chips", "3.05"));
        sut.addToReport(new Candy(snack1,  "chips", "3.05"));
        sut.addToReport(new Candy(snack1,  "chips", "3.05"));

        sut.writeToReportFile();

        try (Scanner reader = new Scanner(new File(sut.getDateTime()))) {
            while (reader.hasNextLine()) {
                reportData.add(reader.nextLine());
                if (reportData.get(reportData.size() - 1).contains("|")) {
                    reportData.remove(reportData.size() - 1);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        reportData.remove(0);
        double total = Double.parseDouble(reportData.get(0).substring(18));
        Assert.assertEquals(9.15, total, 0.01);
    }

    @Test
    public void test_for_accurate_totals2() {
        List<String> reportData = new ArrayList<>();


        sut.addToReport(new Candy(snack1,  "chips", "3.05"));
        sut.addToReport(new Candy(snack1,  "chips", "3.05"));
        sut.addToReport(new Candy(snack1,  "chips", "3.05"));
        sut.addToReport(new Candy(snack1,  "chips", "3.05"));

        sut.addToReport(new Candy(snack2,  "chips", "3.05"));
        sut.addToReport(new Candy(snack2,  "chips", "3.05"));
        sut.addToReport(new Candy(snack2,  "chips", "3.05"));
        sut.addToReport(new Candy(snack2,  "chips", "3.05"));
        sut.addToReport(new Candy(snack2,  "chips", "3.05"));
        sut.addToReport(new Candy(snack2,  "chips", "3.05"));
        sut.writeToReportFile();

        try (Scanner reader = new Scanner(new File(sut.getDateTime()))) {
            while (reader.hasNextLine()) {
                reportData.add(reader.nextLine());
                if (reportData.get(reportData.size() - 1).contains("|")) {
                    reportData.remove(reportData.size() - 1);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        reportData.remove(0);
        double total = Double.parseDouble(reportData.get(0).substring(18));
        Assert.assertEquals(30.5, total, 0.01);
    }
}
