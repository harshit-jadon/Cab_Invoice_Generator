package com.bridgelabz.testcabinvoice;

import com.bridgelabz.cabinvoice.service.CabInvoice;
import com.bridgelabz.cabinvoice.entity.InvoiceSummary;
import com.bridgelabz.cabinvoice.entity.Rides;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

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
    public void givenMultipleRides_shouldReturnTotalFareSummary() {
        CabInvoice cabInvoice = new CabInvoice();
        Rides[] rides = {new Rides(5, 20),
                        new Rides(6, 17),
                        new Rides(4, 20),
                        new Rides(9, 47)};
        InvoiceSummary actualSummary = cabInvoice.totalFareOfJourney(Arrays.asList(rides));
        InvoiceSummary expectedSummary = new InvoiceSummary(4, 344);
        Assert.assertEquals(expectedSummary, actualSummary);
    }

    @Test
    public void givenUserID_ShouldReturnInvoiceSummary() {
        CabInvoice cabInvoice = new CabInvoice();
        Rides[] rides = {new Rides(5, 20),
                new Rides(6, 17),
                new Rides(4, 20),
                new Rides(9, 47)};
        cabInvoice.addInRideRepository(1, Arrays.asList(rides));
        InvoiceSummary actualSummary = cabInvoice.totalFareOfJourney(1);
        InvoiceSummary expectedSummary = new InvoiceSummary(4, 344);
        Assert.assertEquals(expectedSummary, actualSummary);
    }
}
