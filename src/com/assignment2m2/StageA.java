package com.assignment2m2;

import java.util.*;

public class StageA {

    //instance variables
    static Scanner sc;
   // boolean menuReturn = true;
    int numAct = 0;
    Activity[] activities;
    int currentAct = 0;

    //constructor
    public StageA() {
        this.sc = new Scanner(System.in);
    }

    public static void main(String[] args) {
        StageA app = new StageA();
        app.asksForNumberOfActivities();
        app.activities = new Activity[app.numAct];
        while (true) {
            app.printMenu();
            switch (app.returnChoice()) {
                case 1:
                    if(app.currentAct == app.activities.length)
                    {
                        System.out.println("Error - You cannot add any more activities.");
                    }else{
                        for (int i = 0; i < app.activities.length; i++) {
                        String title = app.asksForNameOfActivity();
                        String description = app.asksForDescriptionOfActivity();
                        int ticketsSold = app.asksForTicketsSold();
                        int ticketType = app.asksForTicketType();
                        app.activities[i] = new Activity(title, description, ticketsSold, ticketType);
                            app.currentAct++;
                        for (int j = 0; j < ticketType; j++) {
                            String ticketName = app.asksForTicketName();
                            double price = app.asksForPrice();
                            app.activities[i].setTicket(j, ticketName, price);
                        }
                        }
                        }
                    break;
                case 2:
                    String target;
                    Activity a;
                    a = null;
                    String name;
                    System.out.println("Enter name of Activity: ");
                    sc.nextLine();
                    target = sc.nextLine();
                    for(int i=0; i < app.activities.length && a == null; i++) {
                      name = app.activities[i].getActivityTitle();
                      if (name.equals(target)) {
                       a = app.activities[i];
                       a.displayDetails();
                      }
                    }
                    if (a == null)
                    {System.out.println("Error - " + target + " not found!" );}
                    break;
                // Option 3 displays all stock in a neat table
                case 3:
                    //  int i = 0;
                    for (int i = 0; i < app.activities.length; i++) {
                        System.out.println("================Activities================");
                        app.activities[i].displayDetails();
                    }
                    break;
                case 4:
                    break;
                //exits the program
                case 5:
                    System.out.println("You have quit the program\r\n");
                    System.exit(0);
                    break;
                //Error Message/menu validation
                default:
                    System.out.println("\nYou have entered an invalid selection, please try again \n");
            }

        }
    }
    //prints the menu
    public void printMenu() {
        //Welcomes the user to the application and display menu
        String mainMenu = ("MENU: \n" +
                "----------------------------------------\n" +
                "[1] Enter details of new activity\n" +
                "[2] Display specific activity\n" +
                "[3] Display all activities\n" +
                "[4] Process booking of new activity\n" +
                "[5] Exit program\n" + " \n" +
                "Please make your selection now (1-5) ");
        System.out.println(mainMenu);
    }

    public void asksForNumberOfActivities() {
        boolean isNumber;
        while (isNumber = true) {
            System.out.println("Please enter the maximum number of activities");
            if (sc.hasNextInt()) {
                numAct = returnChoice();
                break;
            } else {
                System.out.println("Your input is invalid");
                isNumber = false;
                sc.next();
            }
        }
    }

    public int returnChoice() {
        return sc.nextInt();
    }

    public String asksForNameOfActivity() {
        System.out.println("Please enter the name of the activity");
        String title = sc.next();
        return title;
    }

    public int asksForTicketsSold() {
        System.out.println("How many tickets have been sold?");
        int ticketsSold = sc.nextInt();
        return ticketsSold;
    }

    public String asksForDescriptionOfActivity() {
        sc.nextLine();
        System.out.println("Please enter description of activity");
        String description = sc.nextLine();
        return description;
    }

    public int asksForTicketType() {
        sc.nextLine();
        int ticketType;
        System.out.println("Please enter the number of Ticket Types");
        ticketType = sc.nextInt();
        return ticketType;
    }

    public double asksForPrice() {
        sc.nextLine();
        double price;
        System.out.println("Please enter the price of the ticket");
        price = sc.nextDouble();
        return price;
    }

    public String asksForTicketName() {
        String ticketName;
        System.out.println("Please enter the name of Ticket");
        ticketName = sc.nextLine();
        return ticketName;
    }
}