package com.Repostory;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Entity.VehicleModel;

public interface VehicleModelRepository
        extends JpaRepository<VehicleModel, Long> {

    Optional<VehicleModel>
    findByModelNameAndVehicleMake_Id(
            String modelName,
            Long makeId
    );

    List<VehicleModel>
    findByVehicleMake_Id(
            Long makeId
    );
}