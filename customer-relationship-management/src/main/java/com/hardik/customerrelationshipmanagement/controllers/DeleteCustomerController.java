package com.hardik.customerrelationshipmanagement.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hardik.customerrelationshipmanagement.exceptions.InvalidCustomerIdException;
import com.hardik.customerrelationshipmanagement.repository.CustomerRepository;

@Controller
public class DeleteCustomerController {
	
	private CustomerRepository customerRepository;

	@Autowired
	public DeleteCustomerController(CustomerRepository customerRepository) {
		super();
		this.customerRepository = customerRepository;
	}
	
	@RequestMapping("/delete")
	public String deleteCustomerHandler(@RequestParam("id") int id) {
		customerRepository.delete(customerRepository.findById(id).orElseThrow(()-> new InvalidCustomerIdException()));
		return "redirect:/";
	}

}
