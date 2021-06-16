package com.bridgelabz.cabinvoice.service;

import com.bridgelabz.cabinvoice.entity.InvoiceSummary;
import com.bridgelabz.cabinvoice.entity.Rides;
import com.bridgelabz.cabinvoice.repository.RideRepository;

import java.util.List;

public class CabInvoice {
    private static final int COST_PER_KM = 10;
    private static final int COST_PER_MIN = 1;
    private static final int MINIMUM_COST = 5;

    RideRepository rideRepository = new RideRepository();

    public double totalFareOfJourney(double distance, int time) {
        double cost = (distance*COST_PER_KM) + (time*COST_PER_MIN);
        return cost < MINIMUM_COST ? MINIMUM_COST : cost;
    }
    public InvoiceSummary totalFareOfJourney(List<Rides> rides) {
        double fareForMultipleRide = 0;
        for (Rides ride:rides) {
           fareForMultipleRide += this.totalFareOfJourney(ride.distance, ride.time);
        }
        return new InvoiceSummary(rides.size(), fareForMultipleRide);
    }
    public InvoiceSummary totalFareOfJourney(Integer userId) {
        return totalFareOfJourney(this.rideRepository.getList(userId));
    }
    public void addInRideRepository(Integer userId, List<Rides> rideList) {
        rideRepository.add(userId, rideList);
    }

    public static void main(String[] args) {
        System.out.println("Welcome to CAB INVOICE GENERATOR");
    }

}
