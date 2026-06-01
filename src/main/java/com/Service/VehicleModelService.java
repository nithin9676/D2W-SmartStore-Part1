package com.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Entity.VehicleMake;
import com.Entity.VehicleModel;
import com.Repostory.VehicleMakeRepository;
import com.Repostory.VehicleModelRepository;

@Service
public class VehicleModelService {

    @Autowired
    private VehicleModelRepository vehicleModelRepository;

    @Autowired
    private VehicleMakeRepository vehicleMakeRepository;

    public String insertModelDetails(VehicleModel vehicleModel) {

        if (vehicleModel == null) {
            return "model details required";
        }

        if (vehicleModel.getVehicleMake() == null ||
                vehicleModel.getVehicleMake().getId() == null) {

            return "make id required";
        }

        Optional<VehicleMake> make =
                vehicleMakeRepository.findById(
                        vehicleModel.getVehicleMake().getId()
                );

        if (make.isEmpty()) {
            return "make not found";
        }

        Optional<VehicleModel> existingModel =vehicleModelRepository.findByModelNameAndVehicleMake_Id(vehicleModel.getModelName(),vehicleModel.getVehicleMake().getId()
                );

        if (existingModel.isPresent()) {
            return "model already exists for this make";
        }

        vehicleModel.setVehicleMake(make.get());

        vehicleModelRepository.save(vehicleModel);

        return "model details saved successfully";
    }

    public List<VehicleModel> getModelsByMakeId(Long makeId) {

        return vehicleModelRepository.findByVehicleMake_Id(makeId);
    }
    public List<VehicleModel> getAllModels()
    {
    	return vehicleModelRepository.findAll();
    }
}