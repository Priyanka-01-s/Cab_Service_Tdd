package com.example;

public class Rides {
    double dist;
    double time;
    String category;

    public Rides(double dist, double time,String category){
        this.dist = dist;
        this.time = time;
        this.category = category;
    }

    public double getDistance(){
        return dist;
    }

    public double getTime(){
        return time;
    }

    public String getCategory(){
        return category;
    }
}
