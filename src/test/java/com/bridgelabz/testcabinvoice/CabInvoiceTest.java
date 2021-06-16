package com.bridgelabz.testcabinvoice;

import com.bridgelabz.cabinvoice.CabInvoice;
import com.bridgelabz.cabinvoice.Rides;
import org.junit.Assert;
import org.junit.Test;

public class CabInvoiceTest {
    @Test
    public void givenDistanceAndTime_whenCostPerKilometrePerMin_shouldReturnTotalFare() {
        CabInvoice cabInvoice = new CabInvoice();
        double totalFare = cabInvoice.totalFareOfJourney(7,15);
        Assert.assertEquals(85,totalFare, 0.0);
    }
    @Test
    public void givenDistanceAndTime_whenCostPerKilometrePerMin_shouldReturnMinimumFare() {
        CabInvoice cabInvoice = new CabInvoice();
        double totalFare = cabInvoice.totalFareOfJourney(0.1, 2);
        Assert.assertEquals(5, totalFare, 0.0);
    }

    @Test
    public void givenDistanceAndTime_whenCostPerKilometrePerMin_shouldReturnTotalFareForMultipleRides() {
        CabInvoice cabInvoice = new CabInvoice();
        Rides[] rides ={new Rides(5, 20),
                        new Rides(6, 17),
                        new Rides(4, 20),
                        new Rides(9, 47)};
        double totalFare = cabInvoice.totalFareOfJourney(rides);
        Assert.assertEquals(344,totalFare, 0.0);

    }
 
}
