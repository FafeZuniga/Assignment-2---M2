package com.assignment2m2;

public class Activity {

    static String title;
    static String description;
    static int ticketsSold;

    public Activity(String title, String description, int ticketsSold) {
        this.title = title;
        this.description = description;
        this.ticketsSold = ticketsSold;
    }

    public void displayDetails() {
        System.out.println("Title: " + title);
        System.out.println("Description: " + description);
        System.out.println("Tickets Sold: " + ticketsSold);
    }
    public void setTitle(String title){
        this.title = title;
    }
    public void setDescription(String description){
        this.description = description;
    }
    public void setTicketsSold(int ticketsSold){
        this.ticketsSold = ticketsSold;
    }



}
