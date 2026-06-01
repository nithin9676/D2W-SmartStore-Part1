package com.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Entity.VehicleGeneration;
import com.Entity.VehicleMake;
import com.Entity.VehicleModel;
import com.Entity.VehicleVariant;
import com.Repostory.VehicleGenerationRepository;
import com.Repostory.VehicleVariantRepository;

@Service
public class VehicleVariantService {

    @Autowired
    private VehicleVariantRepository vehicleVariantRepository;

    @Autowired
    private VehicleGenerationRepository vehicleGenerationRepository;

    public String insertVariantDetails(VehicleVariant vehicleVariant) {

        if(vehicleVariant == null) {
            return "variant details required";
        }

        if(vehicleVariant.getVehicleGeneration() == null ||
                vehicleVariant.getVehicleGeneration().getId() == null) {

            return "generation id required";
        }

        if(vehicleVariant.getVariantName() == null ||
                vehicleVariant.getVariantName().trim().isBlank()) {

            return "variant name required";
        }

        Optional<VehicleGeneration> generationOptional =
                vehicleGenerationRepository.findById(
                        vehicleVariant.getVehicleGeneration().getId());

        if(generationOptional.isEmpty()) {
            return "generation not found";
        }

        VehicleGeneration generation = generationOptional.get();

        Optional<VehicleVariant> existingVariant =
                vehicleVariantRepository.findByVariantNameAndVehicleGeneration_Id(
                        vehicleVariant.getVariantName().trim(),
                        generation.getId());

        if(existingVariant.isPresent()) {
            return "variant already exists";
        }

        VehicleModel model = generation.getVehicleModel();

        VehicleMake make = model.getVehicleMake();

        String fullName =
                make.getMakeName() + " " +
                model.getModelName() + " " +
                vehicleVariant.getVariantName() + " " +
                vehicleVariant.getFuelType() + " " +
                vehicleVariant.getTransmission();

        vehicleVariant.setFullName(fullName.trim());

        String slug =
                fullName.toLowerCase()
                        .replace(" ", "-")
                        .replaceAll("[^a-z0-9-]", "");

        vehicleVariant.setSlug(slug);

        vehicleVariant.setVehicleGeneration(generation);

        vehicleVariantRepository.save(vehicleVariant);

        return "vehicle variant saved successfully";
    }

    public List<VehicleVariant> getVariantsByGenerationId(Long generationId) {

        return vehicleVariantRepository.findByVehicleGeneration_Id(generationId);
    }

    public List<Integer> getAllAvailableYears() {

        return vehicleVariantRepository.findDistinctYears();
    }

    public List<String> getMakesByYear(Integer year) {

        if(year == null) {
            return List.of();
        }

        return vehicleVariantRepository.findMakesByYear(year);
    }

    public List<String> getModelsByYearAndMake(Integer year, String make) {

        if(year == null || make == null || make.trim().isBlank()) {
            return List.of();
        }

        return vehicleVariantRepository.findModelsByYearAndMake(
                year,
                make.trim());
    }

    public List<String> getFuelTypesByYearMakeModel(Integer year,
                                                    String make,
                                                    String model) {

        if(year == null ||
                make == null || make.trim().isBlank() ||
                model == null || model.trim().isBlank()) {

            return List.of();
        }

        return vehicleVariantRepository.findFuelTypes(
                year,
                make.trim(),
                model.trim());
    }

    public List<VehicleVariant> filterVariants(Integer year,
                                               String make,
                                               String model,
                                               String fuelType) {

        if(year == null ||
                make == null || make.trim().isBlank() ||
                model == null || model.trim().isBlank() ||
                fuelType == null || fuelType.trim().isBlank()) {

            return List.of();
        }

        return vehicleVariantRepository.filterVariants(
                year,
                make.trim(),
                model.trim(),
                fuelType.trim());
    }

    public List<VehicleVariant> getAllVariants() {

        return vehicleVariantRepository.findAll();
    }
    
    
}