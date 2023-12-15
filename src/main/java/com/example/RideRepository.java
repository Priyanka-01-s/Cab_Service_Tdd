package com.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RideRepository {

    //userId -> list of rides 

    Map<Integer, List<Rides>> userRideInfo = new HashMap<>();

    public void addRide(int userId, Rides rides){
        userRideInfo.computeIfAbsent(userId, k->new ArrayList<>()).add(rides);

    }

    public Rides[] getRidesForUser(int userId) {
        return userRideInfo.getOrDefault(userId, new ArrayList<>()).toArray(new Rides[0]);
    }
    
}
