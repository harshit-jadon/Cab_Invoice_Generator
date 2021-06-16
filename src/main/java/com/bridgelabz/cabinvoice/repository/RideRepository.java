package com.bridgelabz.cabinvoice.repository;

import com.bridgelabz.cabinvoice.entity.Rides;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RideRepository {
    Map<Integer, List<Rides>> rideRepository;

    public RideRepository() {
        this.rideRepository = new HashMap<>();
    }
    public void add(Integer userId, List<Rides> rideList) {
        this.rideRepository.put(userId, rideList);
    }
    public List<Rides> getList(Integer userId) {
        return this.rideRepository.get(userId);
    }
}
