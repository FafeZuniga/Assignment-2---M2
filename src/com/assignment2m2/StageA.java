package com.assignment2m2;

import java.util.*;

public class StageA {

    //instance variables
    static Scanner sc;
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
                    String answero = "";
                    do{
                        if (app.currentAct == app.activities.length) {
                            System.out.println("Error - You cannot add any more activities.\n");
                        } else {
                            for (int i = 0; i < app.activities.length; i++) {
                                String title = app.asksForNameOfActivity();
                                String description = app.asksForDescriptionOfActivity();
                                int ticketType = app.asksForTicketType();
                                app.activities[i] = new Activity(title, description, ticketType);
                                app.currentAct++;
                                for (int j = 0; j < ticketType; j++) {
                                    String ticketName = app.asksForTicketName();
                                    double price = app.asksForPrice();
                                    app.activities[i].setTicket(j, ticketName, price);
                                    System.out.println("Would you like to continue? Y/N");
                                    answero = sc.next();
                                }
                            }
                        }
                    }while (answero.equalsIgnoreCase("y"));
                    break;
                // Option 2 searches for a specific activitiy
                case 2:
                    app.searchAct();
                    break;
                // Option 3 displays all stock in a neat table
                case 3:
                    for (int i = 0; i < app.activities.length; i++) {
                        System.out.println("================Activities================");
                        app.activities[i].displayDetails();
                    }
                    break;
                case 4:
                    int position;
                    position = app.findAct();
                    if (position == -1) {
                        System.out.println("Not found");
                        break;
                    }
                    System.out.println("Would you like to book a ticket for this activity? Y/N");
                    String answer = sc.nextLine();
                    if (answer.equalsIgnoreCase("Y")) {
                        app.activities[position].displayDetails();
                        System.out.println("Please enter the type of ticket you would like to purchase: ");
                        String purchase = sc.nextLine();
                        System.out.println("Please enter the name of the person: ");
                        String name = sc.nextLine();
                        int loc = app.activities[position].getTicketIndex(purchase);
                        if (loc == -1) {
                            System.out.println("Invalid ticket name");
                            break;
                        }
                        boolean result = app.activities[position].bookActivity(loc, name);


                    } else if (answer.equalsIgnoreCase("N")) {
                        System.out.println("See you next time");
                    } else {
                        System.out.println("Invalid selection - Please try again");
                    }
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
        int ticketType;
        System.out.println("Please enter the number of Ticket Types");
        ticketType = sc.nextInt();
        sc.nextLine();
        return ticketType;
    }

    public double asksForPrice() {
        double price;
        System.out.println("Please enter the price of the ticket");
        price = sc.nextDouble();
        sc.nextLine();
        return price;

    }

    public String asksForTicketName() {
        String ticketName;
        System.out.println("Please enter the name of Ticket");
        ticketName = sc.nextLine();
        return ticketName;
    }

    public void searchAct() {
        String target;
        Activity a;
        a = null;
        String name;
        System.out.println("Enter name of Activity: ");
        sc.nextLine();
        target = sc.nextLine();
        for (int i = 0; i < activities.length && a == null; i++) {
            name = activities[i].getActivityTitle();
            if (name.equals(target)) {
                a = activities[i];
                a.displayDetails();
            }
        }
        if (a == null) {
            System.out.println("Error - " + target + " not found!");
        }
    }
    public int findAct() {
        String target;
        Activity a;
        a = null;
        String name;
        System.out.println("Enter name of Activity: ");
        sc.nextLine();
        target = sc.nextLine();
        for (int i = 0; i < activities.length && a == null; i++) {
            name = activities[i].getActivityTitle();
            if (name.equals(target)) {
                return i;
            }
        }
        return -1;

    }
}