package com.Repostory;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Entity.VehicleMake;


@Repository
public interface VehicleMakeRepository extends JpaRepository<VehicleMake, Long> {

    Optional<VehicleMake> findByMakeNameIgnoreCase(String makeName);

}
