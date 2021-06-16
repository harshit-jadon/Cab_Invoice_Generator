package com.bridgelabz.cabinvoice.service;

import com.bridgelabz.cabinvoice.entity.InvoiceSummary;
import com.bridgelabz.cabinvoice.entity.RideEnum;
import com.bridgelabz.cabinvoice.entity.Rides;
import com.bridgelabz.cabinvoice.repository.RideRepository;

import java.util.List;

public class CabInvoice {
    RideRepository rideRepository = new RideRepository();

    public double totalFareOfJourney(double distance, int time, RideEnum type) {
        return type.totalFareOfJourneyType(distance, time);
    }
    public InvoiceSummary totalFareOfJourney(List<Rides> rides) {
        double fareForMultipleRide = 0;
        for (Rides ride:rides) {
           fareForMultipleRide += this.totalFareOfJourney(ride.distance, ride.time, ride.type);
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
