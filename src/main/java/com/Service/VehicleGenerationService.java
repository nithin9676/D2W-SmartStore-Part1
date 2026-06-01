package com.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Entity.VehicleGeneration;
import com.Entity.VehicleModel;
import com.Repostory.VehicleGenerationRepository;
import com.Repostory.VehicleModelRepository;

@Service
public class VehicleGenerationService {

    @Autowired
    private VehicleGenerationRepository vehicleGenerationRepository;

    @Autowired
    private VehicleModelRepository vehicleModelRepository;

    public String insertGenerationDetails(
            VehicleGeneration vehicleGeneration) {

        if (vehicleGeneration == null) {
            return "generation details required";
        }

        if (vehicleGeneration.getVehicleModel() == null ||
                vehicleGeneration.getVehicleModel().getId() == null) {

            return "model id required";
        }

        Optional<VehicleModel> model =
                vehicleModelRepository.findById(
                        vehicleGeneration.getVehicleModel().getId()
                );

        if (model.isEmpty()) {
            return "model not found";
        }

        Optional<VehicleGeneration> existingGeneration =
        		vehicleGenerationRepository.findByGenerationNameAndVehicleModel_Id(vehicleGeneration.getGenerationName(),vehicleGeneration.getVehicleModel().getId()
                );

        if (existingGeneration.isPresent()) {
            return "generation already exists";
        }

        vehicleGeneration.setVehicleModel(model.get());

        vehicleGenerationRepository.save(vehicleGeneration);

        return "generation details saved successfully";
    }

    public List<VehicleGeneration> getGenerationsByModelId(Long modelId) {

        return vehicleGenerationRepository
                .findByVehicleModel_Id(modelId);
    }
    
    public List<VehicleGeneration> getAllGenerations()
    {
    	return vehicleGenerationRepository.findAll();
    }
}