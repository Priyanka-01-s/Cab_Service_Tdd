package com.example;

public class CaBInvoiceGenerator {

    static final double COST_PER_KM = 10.0;
    static final double COST_PER_MIN = 1.0;
    static final double MINIMUM_FARE = 5.0;

    //For premium car prices
    static final double PREMIUM_COST_PER_KM = 15.0;
    static final double PREMIUM_COST_PER_MIN = 2.0;
    static final double PREMIUM_MINIMUM_FARE = 20.0;
    
    public double calculateFare(double distance, double time){
        double totalFare = distance * COST_PER_KM + time * COST_PER_MIN;

        return Math.max(totalFare, MINIMUM_FARE);
    }

    public double calAggregateTotal(Rides[] ride){
        double totalFare = 0.0;

        for(Rides rides : ride){
            totalFare += calculateFare(rides.getDistance(), rides.getTime());
        }

        return totalFare;

    }

    public double calculateFare(double distance, double time, String category) {
        double costPerKm;
        double costPerMin;
        double minimumFare;

        if ("Normal".equals(category)) {
            costPerKm = COST_PER_KM;
            costPerMin = COST_PER_MIN;
            minimumFare = MINIMUM_FARE;
        } else if ("Premium".equals(category)) {
            costPerKm = PREMIUM_COST_PER_KM;
            costPerMin = PREMIUM_COST_PER_MIN;
            minimumFare = PREMIUM_MINIMUM_FARE;
        } else {
            throw new IllegalArgumentException("Invalid ride category");
        }

        double totalFare = distance * costPerKm + time * costPerMin;

        return Math.max(totalFare, minimumFare);
    }

    public Invoice invoiceInformation(Rides[] ride){
        int numberOfRide = ride.length;
        double aggregateTotal = calAggregateTotal(ride);
        double avgFarePerRide = aggregateTotal/numberOfRide;

        return new Invoice(numberOfRide, aggregateTotal, avgFarePerRide);
    }

}
