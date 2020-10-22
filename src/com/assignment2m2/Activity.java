package com.assignment2m2;

public class Activity {

    private String title;
    private String description;
    private String ticketType[];
    private int ticketsSold;
    private double prices[];
    private String name;
    private String sessionNames[];
    private String numSold[];


    public Activity(String title, String description, int ticketType) {
        this.title = title;
        this.description = description;
        this.ticketsSold = 0;
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

    public int getActivityTicketsSold() {
        return ticketsSold;
    }

    public String getActivityDescription() {
        return description;
    }

    public String getActivityTitle() {
        return title;
    }

     boolean bookActivity(int ticketIndex, String name) {
         ticketsSold++;
         System.out.println("========Ticket Purchase========");
         System.out.println(name + " has bought a ticket for: "+ title +" / "+ ticketType[ticketIndex] +" for $"+ prices[ticketIndex]);
         System.out.println("Have a nice day!");
         System.out.println("");
        return true;
     }

    public int getTicketIndex(String ticketName){
        for(int i=0; i < ticketType.length; i++){
            if(ticketType[i].equalsIgnoreCase(ticketName)){
                return i;
            }
        }
        return -1;
    }
}