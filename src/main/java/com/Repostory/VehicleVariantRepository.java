package com.Repostory;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.Entity.VehicleVariant;

public interface VehicleVariantRepository extends JpaRepository<VehicleVariant, Long> {

    Optional<VehicleVariant> findByVariantNameAndVehicleGeneration_Id(String variantName, Long generationId);

    List<VehicleVariant> findByVehicleGeneration_Id(Long generationId);

    Optional<VehicleVariant> findByFullNameIgnoreCase(String fullName);

    @Query("SELECT DISTINCT v.startYear FROM VehicleVariant v ORDER BY v.startYear DESC")
    List<Integer> findDistinctYears();

    @Query("""
            SELECT DISTINCT v.vehicleGeneration.vehicleModel.vehicleMake.makeName
            FROM VehicleVariant v
            WHERE v.startYear <= :year
            AND (v.endYear IS NULL OR v.endYear >= :year)
            ORDER BY v.vehicleGeneration.vehicleModel.vehicleMake.makeName
            """)
    List<String> findMakesByYear(@Param("year") Integer year);

    @Query("""
            SELECT DISTINCT v.vehicleGeneration.vehicleModel.modelName
            FROM VehicleVariant v
            WHERE v.startYear <= :year
            AND (v.endYear IS NULL OR v.endYear >= :year)
            AND LOWER(v.vehicleGeneration.vehicleModel.vehicleMake.makeName)=LOWER(:make)
            ORDER BY v.vehicleGeneration.vehicleModel.modelName
            """)
    List<String> findModelsByYearAndMake(@Param("year") Integer year,
                                         @Param("make") String make);

    @Query("""
            SELECT DISTINCT v.fuelType
            FROM VehicleVariant v
            WHERE v.startYear <= :year
            AND (v.endYear IS NULL OR v.endYear >= :year)
            AND LOWER(v.vehicleGeneration.vehicleModel.vehicleMake.makeName)=LOWER(:make)
            AND LOWER(v.vehicleGeneration.vehicleModel.modelName)=LOWER(:model)
            ORDER BY v.fuelType
            """)
    List<String> findFuelTypes(@Param("year") Integer year,
                               @Param("make") String make,
                               @Param("model") String model);

    @Query("""
            SELECT v
            FROM VehicleVariant v
            WHERE v.startYear <= :year
            AND (v.endYear IS NULL OR v.endYear >= :year)
            AND LOWER(v.vehicleGeneration.vehicleModel.vehicleMake.makeName)=LOWER(:make)
            AND LOWER(v.vehicleGeneration.vehicleModel.modelName)=LOWER(:model)
            AND LOWER(v.fuelType)=LOWER(:fuelType)
            """)
    List<VehicleVariant> filterVariants(@Param("year") Integer year,
                                        @Param("make") String make,
                                        @Param("model") String model,
                                        @Param("fuelType") String fuelType);
    
    Optional<VehicleVariant>
    findByFullName(String fullName);
}