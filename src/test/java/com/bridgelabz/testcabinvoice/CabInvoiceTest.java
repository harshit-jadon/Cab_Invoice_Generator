package com.bridgelabz.testcabinvoice;

import com.bridgelabz.cabinvoice.CabInvoice;
import org.junit.Assert;
import org.junit.Test;

public class CabInvoiceTest {
    @Test
    public void givenDistanceAndTime_whenCostPerKilometrePerMin_shouldReturnTotalFare() {
        CabInvoice cabInvoice = new CabInvoice();
        double totalFare = cabInvoice.totalFareOfJourney(7,15);
        Assert.assertEquals(85,totalFare, 0.0);
    }
}
