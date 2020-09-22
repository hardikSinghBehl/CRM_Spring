package com.hardik.customerrelationshipmanagement.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.hardik.customerrelationshipmanagement.entities.Customer;
import com.hardik.customerrelationshipmanagement.repository.CustomerRepository;

@Controller
public class AddCustomerController {
	
	private CustomerRepository customerRepository;

	@Autowired
	public AddCustomerController(CustomerRepository customerRepository) {
		super();
		this.customerRepository = customerRepository;
	}
	
	@PostMapping("/")
	public String addCustomerHandler(@ModelAttribute("customer") Customer customer) {
		customerRepository.saveAndFlush(customer);
		return "redirect:/";
	}
	
	

}
