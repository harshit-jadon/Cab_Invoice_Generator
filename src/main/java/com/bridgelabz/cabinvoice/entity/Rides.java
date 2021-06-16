package com.bridgelabz.cabinvoice.entity;

public class Rides {

    public final double distance;
    public final int time;
    public RideEnum type;

    public Rides(double distance, int time, RideEnum type) {
        this.distance = distance;
        this.time = time;
        this.type = type;
    }

}
