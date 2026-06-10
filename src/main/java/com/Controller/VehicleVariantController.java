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

   

    @PostMapping
    public String insertVehicleVariant(
            @RequestBody
            VehicleVariant vehicleVariant) {

        return vehicleVariantService
                .insertVariantDetails(
                        vehicleVariant
                );
    }

   

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

    

    @GetMapping
    public List<VehicleVariant>
    getAllVariants() {

        return vehicleVariantService
                .getAllVariants();
    }
    @GetMapping("/years")
    public List<Integer> getAllAvailableYears() {

        return vehicleVariantService
                .getAllAvailableYears();
    }
    @GetMapping("/makes/{year}")
    public List<String> getMakesByYear(
            @PathVariable("year") Integer year) {

        return vehicleVariantService
                .getMakesByYear(year);
    }
    @GetMapping("/models")
    public List<String> getModelsByYearAndMake( @RequestParam("year") Integer year, @RequestParam("make") String make) {

        return vehicleVariantService.getModelsByYearAndMake( year, make );
    }
    @GetMapping("/variants")
    public List<VehicleVariant>
    getVariantsByYearMakeModel( @RequestParam("year") Integer year, @RequestParam("make") String make, @RequestParam("model") String model) {

        return vehicleVariantService
                .getVariantsByYearMakeModel(
                        year,
                        make,
                        model
                );
    }
    
}