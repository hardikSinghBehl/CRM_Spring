package com.hardik.customerrelationshipmanagement.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hardik.customerrelationshipmanagement.entities.Customer;
import com.hardik.customerrelationshipmanagement.repository.CustomerRepository;

@Controller
public class UpdateCustomerController {
	
	private CustomerRepository customerRepository;

	@Autowired
	public UpdateCustomerController(CustomerRepository customerRepository) {
		super();
		this.customerRepository = customerRepository;
	}
	
	@RequestMapping("/update")
	public String updateCustomerHandler(@RequestParam("id") int id,@RequestParam("firstname") String firstName,@RequestParam("lastname") String lastName,@RequestParam("email") String email) {
		customerRepository.save(customerRepository.findById(id).get().setData(firstName, lastName, email));
		return "redirect:/";
	}
	
	

}
