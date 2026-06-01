package com.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Entity.VehicleMake;
import com.Repostory.VehicleMakeRepository;


@Service
public class VehicleMakeService {

    @Autowired
    private VehicleMakeRepository vehicleMakeRepository;

    public String insertMakeDetails(VehicleMake vehicleMake) {
    	
        if (vehicleMake == null || vehicleMake.getMakeName() == null || vehicleMake.getMakeName().trim().isEmpty()) {
            return "make name is required";
        }

        Optional<VehicleMake> existingMake =
                vehicleMakeRepository.findByMakeNameIgnoreCase(vehicleMake.getMakeName().trim());

        if (existingMake.isPresent()) {
            return "make already exists";
        }

        vehicleMakeRepository.save(vehicleMake);

        return "make details saved successfully";
    }

    public List<VehicleMake> getAllMakeDetails() {
        return vehicleMakeRepository.findAll();
    }
}