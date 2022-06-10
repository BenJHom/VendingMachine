package com.techelevator;

public class Application {
    public static void main(String[] args) {
        ControlInterface userInterface = new ControlInterface();
        userInterface.mainMenuDisplay(true );

        /*

        Ben, I hope you don't mind, but I looked at your classes, and I think I figured out the issue with the getChangeInCoins() method.
        It looks like you were calling getChangeInCoins() within a for loop, so you would get the right output the first time it went through,
        but 0s everytime after that. In addition, since the getChangeInCoins() calls subtractMoney(), you were writing to the log each time the
        for loop went through. I moved the getChangeInCoins() outside the loop and everything seems to work fine, at least at a cursory glance.

         */
        //We should probably not have the file writer be in append mode, since we want the log file cleared after each run
        //issues with mod math for .05
        //added a string variable to the snack class that holds the initial double value

        /*
        Ethan, thank you for addressing that bug.  Upon inspection today the log file only produces 0 as given change.
        I addressed it to write the appropriate value as well as changing format money to always produces a ones cents place. I also fixed issues
        with x.05 values. Money formatting issues should be resolved but yesterday I seem to have created
        a problem with calling logFile calling .getCurrentMoney as currentAmount is always 0.
        I think it has to do with how I instantiated money in our logFile object.
         */
    }
}
