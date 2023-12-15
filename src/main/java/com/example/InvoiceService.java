package com.example;

public class InvoiceService {
    private RideRepository rideRepository;

    public InvoiceService(RideRepository rideRepository) {
        this.rideRepository = rideRepository;
    }

    public Invoice generateInvoiceForUser(int userId) {
        Rides[] rides = rideRepository.getRidesForUser(userId);
        return new CaBInvoiceGenerator().invoiceInformation(rides);
    }
}
