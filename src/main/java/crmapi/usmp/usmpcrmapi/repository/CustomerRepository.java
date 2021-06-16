package crmapi.usmp.usmpcrmapi.repository;


import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import crmapi.usmp.usmpcrmapi.domain.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer>{
    
    @Query("select to_char(tc.registerDate,'Mon') as mon, extract(year from tc.registerDate) as year, count(*) as count from Customer tc  group by extract(month from tc.registerDate),2,1 order by 2, extract(month from tc.registerDate)")
    List<Map<String, Object>> queryByCustomersMonth();

    
}