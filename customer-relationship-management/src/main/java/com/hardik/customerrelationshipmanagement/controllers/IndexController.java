package com.hardik.customerrelationshipmanagement.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hardik.customerrelationshipmanagement.entities.Customer;
import com.hardik.customerrelationshipmanagement.repository.CustomerRepository;

@Controller
public class IndexController {
	
	private CustomerRepository customerRepository;
	
	@Autowired
	public IndexController(CustomerRepository customerRepository) {
		super();
		this.customerRepository = customerRepository;
	}

	@GetMapping("/")
	public String indexViewHandler(Model model) {
		List<Customer> customers = customerRepository.findAll();
		
		model.addAttribute("customers", customers);
		model.addAttribute("numberOfUsers", customers.size());
		model.addAttribute("customer", new Customer());
		
		return "index";
	}
}
