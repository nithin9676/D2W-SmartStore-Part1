package com.Repostory;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Entity.VehicleGeneration;


@Repository
public interface VehicleGenerationRepository extends JpaRepository<VehicleGeneration, Long> {

    Optional<VehicleGeneration>findByGenerationNameAndVehicleModel_Id( String generationName, Long modelId);

    List<VehicleGeneration> findByVehicleModel_Id(Long modelId);

}
