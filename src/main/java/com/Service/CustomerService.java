package com.Service;

	import java.util.Optional;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Service;

import com.DTO.CustomerResponseDTO;
import com.Entity.Customer;
import com.Repostory.CustomerRepository;



	@Service
	public class CustomerService {

	    @Autowired
	    private CustomerRepository customerRepository;

	    public CustomerResponseDTO getCustomerByMobile(
	            String mobileNumber) {

	        Customer customer =
	                customerRepository
	                        .findByMobileNumber(
	                                mobileNumber
	                        )
	                        .orElse(null);

	        if(customer == null) {
	            return null;
	        }

	        CustomerResponseDTO dto =
	                new CustomerResponseDTO();

	        dto.setId(customer.getId());
	        dto.setCustomerName(
	                customer.getCustomerName()
	        );
	        dto.setMobileNumber(
	                customer.getMobileNumber()
	        );
	        dto.setAddress(
	                customer.getAddress()
	        );

	        return dto;
	    }

	    public Customer saveCustomer(
	            Customer customer) {

	        return customerRepository.save(customer);
	    }
	

}
