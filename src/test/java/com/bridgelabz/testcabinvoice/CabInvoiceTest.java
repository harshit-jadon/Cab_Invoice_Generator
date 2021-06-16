package com.bridgelabz.testcabinvoice;

import com.bridgelabz.cabinvoice.CabInvoice;
import com.bridgelabz.cabinvoice.InvoiceSummary;
import com.bridgelabz.cabinvoice.Rides;
import org.junit.Assert;
import org.junit.BeforeClass;
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
    public void givenDistanceAndTime_whenCostPerKilometrePerMin_shouldReturnTotalFareSummary() {
        CabInvoice cabInvoice = new CabInvoice();
        Rides[] rides = {new Rides(5, 20),
                        new Rides(6, 17),
                        new Rides(4, 20),
                        new Rides(9, 47)};
        InvoiceSummary actualSummary = cabInvoice.totalFareOfJourney(rides);
        InvoiceSummary expectedSummary = new InvoiceSummary(4, 344);
        Assert.assertEquals(expectedSummary, actualSummary);
    }
}
