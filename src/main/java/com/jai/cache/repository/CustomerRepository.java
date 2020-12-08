package com.jai.cache.repository;

import com.jai.cache.model.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {

  Customer findByFirstname(String firstname);

}
