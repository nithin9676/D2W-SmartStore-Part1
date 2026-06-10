package com.Repostory;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>{
	Optional<Customer> findByMobileNumber(
            String mobileNumber
    );
}
