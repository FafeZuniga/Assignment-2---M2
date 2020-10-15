package com.assignment2m2;

public class Activity {

    private String title;
    private String description;
    private String ticketType[];
    private int ticketsSold;
    private double prices[];


    public Activity(String title, String description, int ticketsSold, int ticketType) {
        this.title = title;
        this.description = description;
        this.ticketsSold = ticketsSold;
        this.ticketType = new String[ticketType];
        this.prices = new double[ticketType];

    }

    public void setTicket(int position, String ticketType, double prices) {
        this.ticketType[position] = ticketType;
        this.prices[position] = prices;
    }

    public void displayDetails() {
        System.out.println("Title: " + getActivityTitle());
        System.out.println("Description: " + getActivityDescription());
        System.out.println("Tickets Sold: " + getActivityTicketsSold());
        for (int i = 0; i < ticketType.length; i++) {
            System.out.println("Ticket Name: " + ticketType[i]);
            System.out.println("Ticket Price: " + prices[i]);
        }
    }

    private int getActivityTicketsSold() {
        return ticketsSold;
    }

    private String getActivityDescription() {
        return description;
    }

    private String getActivityTitle() {
        return title;
    }
}