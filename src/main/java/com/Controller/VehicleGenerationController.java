package com.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.Entity.VehicleGeneration;
import com.Service.VehicleGenerationService;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/vehicle-generations")
public class VehicleGenerationController {

    @Autowired
    private VehicleGenerationService
            vehicleGenerationService;

    /*
    |--------------------------------------------------------------------------
    | INSERT GENERATION
    |--------------------------------------------------------------------------
    */

    @PostMapping
    public String insertVehicleGeneration(
            @RequestBody
            VehicleGeneration vehicleGeneration) {

        return vehicleGenerationService
                .insertGenerationDetails(
                        vehicleGeneration
                );
    }

    /*
    |--------------------------------------------------------------------------
    | GET GENERATIONS BY MODEL
    |--------------------------------------------------------------------------
    */

    @GetMapping("/by-model/{modelId}")
    public List<VehicleGeneration>
    getGenerationsByModelId(
            @PathVariable("modelId")
            Long modelId) {

        return vehicleGenerationService
                .getGenerationsByModelId(
                        modelId
                );
    }

    /*
    |--------------------------------------------------------------------------
    | GET ALL GENERATIONS
    |--------------------------------------------------------------------------
    */

    @GetMapping
    public List<VehicleGeneration>
    getAllGenerations() {

        return vehicleGenerationService
                .getAllGenerations();
    }
}