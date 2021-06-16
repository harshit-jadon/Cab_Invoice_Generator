package com.bridgelabz.cabinvoice.entity;

public enum RideEnum {
    NormalRides(10,1,5),
    PremiumRides(15,2,20);

    public double costPerKm;
    public int costPerMin;
    public int minimumFare;

    RideEnum(double costPerKm, int costPerMin, int minimumFare) {
        this.costPerKm = costPerKm;
        this.costPerMin = costPerMin;
        this.minimumFare = minimumFare;
    }
    public double totalFareOfJourneyType(double distance, int time) {
        double cost = (distance * this.costPerKm) + (time * this.costPerMin);
        return cost < this.minimumFare ? this.minimumFare : cost;
    }
}
