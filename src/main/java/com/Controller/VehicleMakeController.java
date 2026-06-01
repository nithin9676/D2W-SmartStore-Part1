package com.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.Entity.VehicleMake;
import com.Service.VehicleMakeService;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/vehicle-makes")
public class VehicleMakeController {

    @Autowired
    private VehicleMakeService vehicleMakeService;

    @PostMapping
    public String insertVehicleMake(@RequestBody VehicleMake vehicleMake) {

        return vehicleMakeService.insertMakeDetails(vehicleMake);
    }

    @GetMapping
    public List<VehicleMake> getAllVehicleMakes() {

        return vehicleMakeService.getAllMakeDetails();
    }
}