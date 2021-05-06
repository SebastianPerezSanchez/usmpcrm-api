package crmapi.usmp.usmpcrmapi.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import crmapi.usmp.usmpcrmapi.domain.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer>{
    
}