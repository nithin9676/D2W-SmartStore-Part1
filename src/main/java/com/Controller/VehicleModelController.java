package com.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.Entity.VehicleModel;
import com.Service.VehicleModelService;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/vehicle-models")
public class VehicleModelController {

    @Autowired
    private VehicleModelService
            vehicleModelService;

    @PostMapping
    public String insertVehicleModel(
            @RequestBody
            VehicleModel vehicleModel) {

        return vehicleModelService
                .insertModelDetails(
                        vehicleModel
                );
    }

   

    @GetMapping("/by-make/{makeId}")
    public List<VehicleModel>
    getModelsByMakeId(
            @PathVariable("makeId")
            Long makeId) {

        return vehicleModelService
                .getModelsByMakeId(
                        makeId
                );
    }

    /*
    |--------------------------------------------------------------------------
    | GET ALL MODELS
    |--------------------------------------------------------------------------
    */

    @GetMapping
    public List<VehicleModel>
    getAllVehicleModels() {

        return vehicleModelService
                .getAllModels();
    }
}