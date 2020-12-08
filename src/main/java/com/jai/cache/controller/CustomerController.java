package com.jai.cache.controller;

import com.jai.cache.model.Customer;
import com.jai.cache.repository.CustomerRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/gemfire")
public class CustomerController {

  CustomerRepository customerRepository;

  public CustomerController(){}

  public CustomerController(CustomerRepository customerRepository) {
    this.customerRepository = customerRepository;
  }

  @PostMapping(value = "/customers")
  public String save(@PathVariable String firstName) {
    Customer peter = new Customer("Peter", "Williams", 20);
    Customer mary = new Customer("Mary", "Diaz", 25);
    customerRepository.save(peter);
    customerRepository.save(mary);
    return "customer saved";
  }

  @GetMapping(value = "/customers/{firstName}")
  public Customer findCustomerByFirstName(@PathVariable String firstName) {
    return customerRepository.findByFirstname(firstName);
  }
}
