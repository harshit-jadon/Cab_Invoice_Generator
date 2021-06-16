package com.bridgelabz.cabinvoice;

public class CabInvoice {
    private static final int COST_PER_KM = 10;
    public double totalFareOfJourney(double distance, int time) {
        return (distance*COST_PER_KM) + time;
    }

    public static void main(String[] args) {
        System.out.println("Welcome to CAB INVOICE GENERATOR");
    }
    }
