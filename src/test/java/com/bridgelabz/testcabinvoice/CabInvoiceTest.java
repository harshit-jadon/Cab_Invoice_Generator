package com.bridgelabz.testcabinvoice;

import com.bridgelabz.cabinvoice.entity.RideEnum;
import com.bridgelabz.cabinvoice.service.CabInvoice;
import com.bridgelabz.cabinvoice.entity.InvoiceSummary;
import com.bridgelabz.cabinvoice.entity.Rides;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class CabInvoiceTest {
    @Test
    public void givenDistanceAndTimeForNormal_whenCostPerKilometrePerMin_shouldReturnTotalFare() {
        CabInvoice cabInvoice = new CabInvoice();
        double totalFare = cabInvoice.totalFareOfJourney(7,15, RideEnum.NormalRides);
        Assert.assertEquals(85,totalFare, 0.0);
    }
    @Test
    public void givenDistanceAndTimeForNormal_whenCostPerKilometrePerMin_shouldReturnMinimumFare() {
        CabInvoice cabInvoice = new CabInvoice();
        double totalFare = cabInvoice.totalFareOfJourney(0.1, 2,RideEnum.NormalRides);
        Assert.assertEquals(5, totalFare, 0.0);
    }
    @Test
    public void givenDistanceAndTimeForPremium_whenCostPerKilometrePerMin_shouldReturnTotalFare() {
        CabInvoice cabInvoice = new CabInvoice();
        double totalFare = cabInvoice.totalFareOfJourney(7,15, RideEnum.PremiumRides);
        Assert.assertEquals(135,totalFare, 0.0);
    }
    @Test
    public void givenDistanceAndTimeForPremium_whenCostPerKilometrePerMin_shouldReturnMinimumFare() {
        CabInvoice cabInvoice = new CabInvoice();
        double totalFare = cabInvoice.totalFareOfJourney(0.1, 2,RideEnum.PremiumRides);
        Assert.assertEquals(20, totalFare, 0.0);
    }
    @Test
    public void givenMultipleRides_shouldReturnTotalFareSummary() {
        CabInvoice cabInvoice = new CabInvoice();
        Rides[] rides = {new Rides(5, 20,RideEnum.NormalRides),
                        new Rides(6, 17,RideEnum.NormalRides),
                        new Rides(4, 20,RideEnum.NormalRides),
                        new Rides(9, 47,RideEnum.NormalRides)};
        InvoiceSummary actualSummary = cabInvoice.totalFareOfJourney(Arrays.asList(rides));
        InvoiceSummary expectedSummary = new InvoiceSummary(4, 344);
        Assert.assertEquals(expectedSummary, actualSummary);
    }

    @Test
    public void givenUserID_ShouldReturnInvoiceSummary() {
        CabInvoice cabInvoice = new CabInvoice();
        Rides[] rides = {new Rides(5, 20,RideEnum.NormalRides),
                new Rides(6, 17,RideEnum.NormalRides),
                new Rides(4, 20,RideEnum.NormalRides),
                new Rides(9, 47,RideEnum.NormalRides)};
        cabInvoice.addInRideRepository(1, Arrays.asList(rides));
        InvoiceSummary actualSummary = cabInvoice.totalFareOfJourney(1);
        InvoiceSummary expectedSummary = new InvoiceSummary(4, 344);
        Assert.assertEquals(expectedSummary, actualSummary);
    }

}
