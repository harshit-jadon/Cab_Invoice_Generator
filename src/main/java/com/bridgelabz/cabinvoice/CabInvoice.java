package com.bridgelabz.cabinvoice;


public class CabInvoice {
    private static final int COST_PER_KM = 10;
    private static final int COST_PER_MIN = 1;
    private static final int MINIMUM_COST = 5;

    public double totalFareOfJourney(double distance, int time) {
        double cost = (distance*COST_PER_KM) + (time*COST_PER_MIN);
        return cost < MINIMUM_COST ? MINIMUM_COST : cost;
    }
    public InvoiceSummary totalFareOfJourney(Rides[] rides) {
        double fareForMultipleRide = 0;
        for (Rides ride:rides) {
           fareForMultipleRide += this.totalFareOfJourney(ride.distance, ride.time);
        }
        return new InvoiceSummary(rides.length, fareForMultipleRide);
    }
    public static void main(String[] args) {
        System.out.println("Welcome to CAB INVOICE GENERATOR");
    }

}
