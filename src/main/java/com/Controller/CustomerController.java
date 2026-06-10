package com.Controller;
 
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.web.bind.annotation.*;

import com.DTO.CustomerResponseDTO;
import com.Entity.Customer;
import com.Service.CustomerService;
	@RestController
	@RequestMapping("/customers")
	@CrossOrigin(origins = "*")
	public class CustomerController {
		@Autowired
	    private CustomerService customerService;

		@GetMapping("/mobile/{mobile}")
		public CustomerResponseDTO getCustomerByMobile(
		        @PathVariable("mobile") String mobile) {

		    return customerService
		            .getCustomerByMobile(mobile);
		}
	    @PostMapping
	    public Customer saveCustomer( @RequestBody Customer customer) {

	        return customerService.saveCustomer(
	                customer);
	    
	}
}
