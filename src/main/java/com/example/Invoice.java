package com.example;

public class Invoice {
    private int totalRides;
    private double totalFare;
    private double avgFare;

    public Invoice(int totalRides, double totalFare, double avgFare){
        this.totalRides = totalRides;
        this.totalFare = totalFare;
        this.avgFare = avgFare;
    }

    public int getTotalRides(){
        return totalRides;
    }
    public double getTotalFare(){
        return totalFare;
    }

    public double getavgFare(){
        return avgFare;
    }
    
}
