package com.Repostory;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Entity.ProductMaster;

@Repository
public interface ProductMasterRepository
        extends JpaRepository<ProductMaster, Long> {

    Optional<ProductMaster> findByMasterNameAndCategory_Id( String masterName, Long categoryId
    );

    Optional<ProductMaster>findByMasterNameIgnoreCase(String masterName);

}