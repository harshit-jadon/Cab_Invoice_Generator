package com.bridgelabz.cabinvoice;

public class InvoiceSummary {
    public final int noOfRides;
    public final double totalFares;
    public final double averageFare;

    public InvoiceSummary(int noOfRides, double totalFares) {
        this.noOfRides = noOfRides;
        this.totalFares = totalFares;
        this.averageFare = this.totalFares/this.noOfRides;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InvoiceSummary that = (InvoiceSummary) o;
        return noOfRides == that.noOfRides && Double.compare(that.totalFares, totalFares) == 0 && Double.compare(that.averageFare, averageFare) == 0;
    }

}
