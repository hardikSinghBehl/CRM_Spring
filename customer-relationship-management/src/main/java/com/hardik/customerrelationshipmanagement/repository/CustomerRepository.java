package com.hardik.customerrelationshipmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hardik.customerrelationshipmanagement.entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{

}
