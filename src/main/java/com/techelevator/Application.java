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
    }
}
