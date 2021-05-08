package crmapi.usmp.usmpcrmapi.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import crmapi.usmp.usmpcrmapi.domain.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order,Integer>{
    
}