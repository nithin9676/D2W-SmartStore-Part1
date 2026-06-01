package com.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.Entity.VehicleVariant;
import com.Service.VehicleVariantService;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/vehicle-variants")
public class VehicleVariantController {

    @Autowired
    private VehicleVariantService
            vehicleVariantService;

    /*
    |--------------------------------------------------------------------------
    | INSERT VARIANT
    |--------------------------------------------------------------------------
    */

    @PostMapping
    public String insertVehicleVariant(
            @RequestBody
            VehicleVariant vehicleVariant) {

        return vehicleVariantService
                .insertVariantDetails(
                        vehicleVariant
                );
    }

    /*
    |--------------------------------------------------------------------------
    | GET VARIANTS BY GENERATION
    |--------------------------------------------------------------------------
    */

    @GetMapping("/by-generation/{generationId}")
    public List<VehicleVariant>
    getVariantsByGenerationId(
            @PathVariable("generationId")
            Long generationId) {

        return vehicleVariantService
                .getVariantsByGenerationId(
                        generationId
                );
    }

    /*
    |--------------------------------------------------------------------------
    | GET ALL VARIANTS
    |--------------------------------------------------------------------------
    */

    @GetMapping
    public List<VehicleVariant>
    getAllVariants() {

        return vehicleVariantService
                .getAllVariants();
    }
}