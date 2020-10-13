package com.assignment2m2;

import java.util.*;

public class StageA {

    //instance variables
    static Scanner sc;
    int numAct;
    boolean menuReturn = true;
    int numOfActivities[] = new int[numAct];
    String activityTitle;
    String activityDescription;
    int activityTicketsSold;

    //constructor
    public StageA() {
        this.sc = new Scanner(System.in);
    }

    public static void main(String[] args) {
        StageA app = new StageA();
        app.asksForNumberOfActivities();
        Activity activity = new Activity(app.activityTitle, app.activityDescription, app.activityTicketsSold);
        while(app.menuReturn = true) {
            app.printMenu();
            switch (app.returnChoice()) {
                case 1 ://activity.enterDetailsForNewActivities();
                    break;
                case 2 : //activity.displayDetails();
                    break;
                // Option 3 displays all stock in a neat table
                case 3 :
                    break;
                case 4 :
                    break;
                //exits the program
                case 5 :System.out.println("You have quit the program\r\n");
                    System.exit(0);
                    break;
                //Error Message/menu validation
                default:System.out.println("\nYou have entered an invalid selection, please try again \n");
            }
        }
    }
    //prints the menu
    public void printMenu() {
        //Welcomes the user to the application and display menu
        String mainMenu = ("MENU: \n" +
                "----------------------------------------\n"+
                "[1] Enter details of new activity\n"+
                "[2] Display specific activity\n" +
                "[3] Display all activities\n" +
                "[4] Process booking of new activity\n" +
                "[5] Exit program\n" + 						" \n"+
                "Please make your selection now (1-5) ");
        System.out.println(mainMenu);
    }
   public void asksForNumberOfActivities(){
        boolean isNumber;
        while (isNumber = true) {
            System.out.println("Please enter the maximum number of activities");
            if (sc.hasNextInt()) {
                numAct = sc.nextInt();
                break;
            } else {
                System.out.println("Your input is invalid");
                isNumber = false;
                sc.next();
            }
        }
    }


    public int returnChoice() {return sc.nextInt();}

    public void asksForNameOfActivity(){
        System.out.println("Please enter the name of the activity");
        activityTitle = sc.next();
    }

    public void asksForTicketsSold(){
        System.out.println("How many tickets have been sold?");
        activityTicketsSold = sc.nextInt();
    }

    public void asksForDescriptionOfActivity(){
        System.out.println("Please enter description of activity");
        activityDescription = sc.next();
    }


}
